package designpatterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InnerClassSingletonTest {

    @Test
    void checkDuplicateTest() {
        assertNotNull(InnerClassSingleton.getInstance());
        assertTrue(InnerClassSingleton.getInstance() == InnerClassSingleton.getInstance());
    }

}