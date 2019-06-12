package multithreading.accounttransfer11;

import multithreading1.accounttransfer11.AccountTransfer;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AccountTransferTest {

    @Test
    public void accountTransferTest() {
        AccountTransfer accountTransfer = new AccountTransfer();
        accountTransfer.startTransfer();
        assertThat(accountTransfer.getTotal(), is(20_000));
    }
}
