package DataStructure;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * テスト書かないとかそれ@t_wadaの前でも言えんの？
 */
public class SLLCodeInterviewTest {
    /**
     * Code Interview Chapter 2: Question 1
     * ソートされていない連結リストから、重複する要素を削除するコードを書いてください
     */
    @Test
    public void removeDuplicationTest(){
        {
            // 単純な重複に対するテスト
            SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
            list.addLast(1).addLast(2).addLast(3).addLast(4).addLast(2); // list[1,2,3,4,2]
            list.removeDuplication();
            assertThat(list, is((new SinglyLinkedList<Integer>()).addLast(1).addLast(2).addLast(3).addLast(4)));
        }
        {
            // 多重な重複に対するテスト
            SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
            list.addLast(1).addLast(1).addLast(2).addLast(1).addLast(1); // list[1,2,3,4,2]
            list.removeDuplication();
            assertThat(list, is((new SinglyLinkedList<Integer>()).addLast(1).addLast(2)));
        }
        {
            // 多重な重複が複数の要素で存在する場合のテスト
            SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
            list.addLast(1).addLast(1).addLast(2).addLast(1).addLast(1).addLast(2).addLast(2).addLast(3).addLast(1); // list[1,2,3,4,2]
            list.removeDuplication();
            assertThat(list, is((new SinglyLinkedList<Integer>()).addLast(1).addLast(2).addLast(3)));
        }
        {
            // 要素が１個のリストに対するテスト
            SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
            list.addLast(1); // list[1]
            list.removeDuplication();
            assertThat(list, is((new SinglyLinkedList<Integer>()).addLast(1)));
        }
        {
            // 要素が空のリストに対するテスト
            SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
            list.removeDuplication();
            assertThat(list, is((new SinglyLinkedList<Integer>())));
        }
    }

    /**
     * Code Interview Chapter 2: Question 2
     * 単方向連結リストにおいて、末尾から数えてk番目の要素を見つけるアルゴリズムを実装してください
     */
    @Test
    public void getNthToLastTest(){
        {
            SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
            list.addLast(1).addLast(2).addLast(3).addLast(4).addLast(2); // list[1,2,3,4,2]
            assertThat(list.getNthToLast(0), is(2));
            assertThat(list.getNthToLast(1), is(4));
            assertThat(list.getNthToLast(2), is(3));
            assertThat(list.getNthToLast(3), is(2));
            assertThat(list.getNthToLast(4), is(1));
        }
        {
            SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
            list.addLast(1); // list[1]
            assertThat(list.getNthToLast(0), is(1));
        }
    }

    /**
     * Code Interview Chapter 2: Question 3
     * 単方向連結リストにおいて、中央の要素のみアクセス可能であるとします。その要素を削除するアルゴリズムを実装してください。
     */
    @Test
    public void deleteCenterNodeTest() {
        {
            SinglyLinkedList<Integer> values = new SinglyLinkedList<Integer>(1,2,3,4,5,6,7,8,9);
            SinglyLinkedList<Integer> expected = new SinglyLinkedList<Integer>(1,2,3,4,6,7,8,9);
            values = values.deleteCenterNode();
            assertThat(values, is(expected));
        }
        {
            SinglyLinkedList<Integer> values = new SinglyLinkedList<Integer>(1,2,3,4,5,6,7,8);
            SinglyLinkedList<Integer> expected = new SinglyLinkedList<Integer>(1,2,3,4,6,7,8);
            values = values.deleteCenterNode();
            assertThat(values, is(expected));
        }
        {
            SinglyLinkedList<Integer> values = new SinglyLinkedList<Integer>(1,2);
            SinglyLinkedList<Integer> expected = new SinglyLinkedList<Integer>(2);
            values = values.deleteCenterNode();
            assertThat(values, is(expected));
        }
        {
            SinglyLinkedList<Integer> values = new SinglyLinkedList<Integer>(1);
            SinglyLinkedList<Integer> expected = new SinglyLinkedList<Integer>();
            values = values.deleteCenterNode();
            assertThat(values, is(expected));
        }
    }

    /**
     * Code Interview Chapter 2: Question 4
     * ある数xが与えられたとき、連結リストの要素を並べ替え、xより小さいものが前にくるようにするコードを書いてください
     */
    @Test
    public void moveElementsToAheadLessThanTest(){
        {
            SinglyLinkedList<Integer> values = new SinglyLinkedList<Integer>(1, 1, 2, 3, 4, 1, 3, 2, 1);
            values.moveElementsToAheadLessThan(3);

            assertTrue(values.getNthToLast(0) >= 3);
            assertTrue(values.getNthToLast(1) >= 3);
            assertTrue(values.getNthToLast(2) >= 3);
        }
        {
            SinglyLinkedList<Integer> values = new SinglyLinkedList<Integer>();
            values.moveElementsToAheadLessThan(3);
        }
    }
}
