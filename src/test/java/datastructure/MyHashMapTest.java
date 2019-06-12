package datastructure;


//import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MyHashMapTest {

    @Test
    public void myHashMapTest() {
        MyHashMap<String, String> myHashMap = new MyHashMap<>(10);
        myHashMap.put("key", "value");
        myHashMap.put("key1", "value1");
        myHashMap.put("key2", "value2");
        assertThat(myHashMap.get("key"), is("value"));
    }
}
