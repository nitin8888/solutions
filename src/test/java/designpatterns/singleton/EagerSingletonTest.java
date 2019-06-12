package designpatterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EagerSingletonTest {

    @Test
    void non_duplicate_singleton_test() {
        // Create 2 instances of singleton & check if equal
        assertTrue(EagerSingleton.getInstance() != null);
        assertTrue(EagerSingleton.getInstance() == EagerSingleton.getInstance());

    }
}