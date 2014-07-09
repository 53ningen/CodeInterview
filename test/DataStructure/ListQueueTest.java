package DataStructure;

import DataStructure.queue.Queue;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ListQueueTest {
    @Test
    public void 一通りキューの利用手順を踏めるか() {
        Queue<Integer> valuesQueue = new ListQueue<Integer>();
        for(int i = 0; i < 2; i++) {
            // 空のキューに対するdequeueはnullを返す
            assertNull(valuesQueue.dequeue());
            assertThat(valuesQueue.size(), is(0));

            valuesQueue.enqueue(3);
            assertThat(valuesQueue.size(), is(1));

            valuesQueue.enqueue(4);
            assertThat(valuesQueue.size(), is(2));

            assertThat(valuesQueue.dequeue(), is(3));
            assertThat(valuesQueue.size(), is(1));


            assertThat(valuesQueue.dequeue(), is(4));
            assertThat(valuesQueue.size(), is(0));
        }
    }
}