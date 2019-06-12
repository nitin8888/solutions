package multithreading.addlists04;

import multithreading1.addlists04.AddLists;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AddListsTest {

    @Test
    public void addListsTest() {
        AddLists addLists = new AddLists();
        addLists.add();
        assertThat(addLists.getTotalListSize(), is(40000));

    }
}
