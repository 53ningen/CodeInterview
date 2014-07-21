package DataStructure;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * テスト書かないとかそれ@t_wadaの前でも言えんの？
 */
public class ThreeStacksSharingOneArrayTest {
    @Test
    public void テスト() {
        ThreeStacksSharingOneArray<Integer> stack = new ThreeStacksSharingOneArray<Integer>(10);
        stack.push(ThreeStacksSharingOneArray.StackPostion.Left, 3);
        assertThat(stack.pop(ThreeStacksSharingOneArray.StackPostion.Left), is(3));

        stack.push(ThreeStacksSharingOneArray.StackPostion.Left, 3);
        assertThat(stack.pop(ThreeStacksSharingOneArray.StackPostion.Left), is(3));

    }
}