package DataStructure;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ArrayStackTest {
    @Test
    public void 基本演算テスト() {
        ArrayStack<Integer> values = new ArrayStack<Integer>(1);
        assertEquals(values.pop(), null);
        values.push(1);
        assertThat(values.pop(), is(1));
    }

    @Test(expected = StackOverflowError.class)
    public void スタックオーバーフロー時に例外をちゃんと投げるか() {
        ArrayStack<Integer> values = new ArrayStack<Integer>(1);
        values.push(1);
        values.push(2);
    }

}