package multithreading.rentrantlock10;

import multithreading1.rentrantlock10.RentrantLockApp;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RentrantLockAppTest {

    @Test
    public void rentrantlockTest() {
        RentrantLockApp rentrantLockApp = new RentrantLockApp();
        rentrantLockApp.startThread();
        rentrantLockApp.waitToFinish();

        assertThat(rentrantLockApp.getCount(), is(20000));
    }
}
