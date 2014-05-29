package DataStructure;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * テスト書かないとかそれ@t_wadaの前でも言えんの？
 */
public class SLLCodeInterviewTest {
    /**
     * Code Interview Chapter 2: Question 1
     * ソートされていない連結リストから、重複する要素を削除するコードを書いてください
     */
    @Ignore
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

    }

    /**
     * Code Interview Chapter 2: Question 2
     * 単方向連結リストにおいて、末尾から数えてk番目の要素を見つけるアルゴリズムを実装してください
     */
    @Ignore
    public void getNthToLastTest(){
        {
            SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
            list.addLast(1).addLast(2).addLast(3).addLast(4).addLast(2); // list[1,2,3,4,2]
            list.removeDuplication();
            assertThat(list.getNthToLast(0), is(2));
            assertThat(list.getNthToLast(1), is(4));
            assertThat(list.getNthToLast(2), is(3));
            assertThat(list.getNthToLast(3), is(2));
            assertThat(list.getNthToLast(4), is(1));
        }
        {
            SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
            list.addLast(1).addLast(2).addLast(3).addLast(4).addLast(2).removeLast().addFirst(5); // list[1,2,3,4,5]
            list.removeDuplication();
            assertThat(list.getNthToLast(0), is(5));
            assertThat(list.getNthToLast(1), is(4));
            assertThat(list.getNthToLast(2), is(3));
            assertThat(list.getNthToLast(3), is(2));
            assertThat(list.getNthToLast(4), is(1));
        }
    }

    /**
     * Code Interview Chapter 2: Question 3
     * 単方向連結リストにおいて、中央の要素のみアクセス可能であるとします。その要素を削除するアルゴリズムを実装してください。
     */
    @Test
    public void deleteCenterNodeTest() {

    }

    /**
     * Code Interview Chapter 2: Question 4
     * ある数xが与えられたとき、連結リストの要素を並べ替え、xより小さいものが前にくるようにするコードを書いてください
     */
    @Test
    public void moveElementsToAheadLessThanTest(){

    }
}
