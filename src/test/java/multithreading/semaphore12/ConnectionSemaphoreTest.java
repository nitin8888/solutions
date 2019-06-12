package multithreading.semaphore12;

import multithreading1.semaphore12.ConnectionSemaphore;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConnectionSemaphoreTest {

    @Test
    public void connectionSemaphoreTest() {
        ConnectionSemaphore connectionSemaphore = new ConnectionSemaphore();
        connectionSemaphore.connect();
        assertThat(connectionSemaphore.getConnection(), is(10));

    }
}
