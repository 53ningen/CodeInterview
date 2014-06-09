package DataStructure;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ListStackTest {
    @Test
    public void 基本演算テスト() {
        ListStack<Integer> values = new ListStack<Integer>();

        assertEquals(values.pop(), null);
        values.push(3);
        assertThat(values.pop(), is(3));

    }

}