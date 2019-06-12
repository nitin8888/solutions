package multithreading1.accounttransfer11;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class AccountTransfer {

    private Account account1 = new Account(10_000);
    private Account account2 = new Account(10_000);
    // Create 2 locks
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    // transfer amounts in loop
    private void transferRandomAmounts(Account fromAccount, Account toAccount, Lock fromLock, Lock toLock) {
        Random random = new Random();
        IntStream.range(0, 10000).forEach(i -> {
            transfer(fromAccount, toAccount, random.nextInt(100), fromLock, toLock);
        });
    }

    private void transfer(Account fromAccount, Account toAccount, int amount, Lock fromLock, Lock toLock) {
        try {
            acquireLock(fromLock, toLock);
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        } finally {
            fromLock.unlock();
            toLock.unlock();
        }
    }

    private void acquireLock(Lock fromLock, Lock toLock) {
        // get from lock & to lock if not success go in infinite loop
        boolean fromLockSuccess = false;
        boolean toLockSuccess = false;

        while (true) {
            try {
                fromLockSuccess = fromLock.tryLock();
                toLockSuccess = toLock.tryLock();
            } finally {
                if (fromLockSuccess && toLockSuccess) {
                    return;
                } else if (fromLockSuccess) {
                    fromLock.unlock();
                } else if (toLockSuccess) {
                    toLock.unlock();
                }
            }
        }
    }


    public int getTotal() {
        System.out.println("account1:" + account1.getBalance());
        System.out.println("account2:" + account2.getBalance());
        System.out.println("Total:" + (account1.getBalance() + account2.getBalance()));
        return account1.getBalance() + account2.getBalance();
    }

    public void startTransfer() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(() -> transferRandomAmounts(account1, account2, lock1, lock2));
        executorService.execute(() -> transferRandomAmounts(account2, account1, lock2, lock1));
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}