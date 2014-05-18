package DataStructure;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SinglyLinkedListTest {
    /**
     * ************************************************
     * リスト挿入系のテスト
     * *************************************************
     */
    @Test
    public void いろんな型でadd操作() {
        SinglyLinkedList<String> stringList = new SinglyLinkedList<String>();
        stringList.addLast("hello").addLast(" ").addLast("world");
        assertThat(stringList.toString(), is("SinglyLinkedList{hello, ,world}"));
    }

    @Test
    public void 単純なadd操作に対するtoStringの動作確認() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.addLast(1);
        assertThat(list.toString(), is("SinglyLinkedList{1}"));

        list.addLast(2).addLast(3).addLast(4);
        assertThat(list.toString(), is("SinglyLinkedList{1,2,3,4}"));

        list.addFirst(5).addFirst(6).addLast(7);
        assertThat(list.toString(), is("SinglyLinkedList{6,5,1,2,3,4,7}"));

        list.addLast(8);
        assertThat(list.toString(), is("SinglyLinkedList{6,5,1,2,3,4,7,8}"));

        list.add(2,9);
        assertThat(list.toString(), is("SinglyLinkedList{6,5,9,1,2,3,4,7,8}"));
    }

    @Test
    public void 正しくaddされるか() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();

    }

    @Test
    public void add系の各メソッドに対して要素数を正しく反映できているか() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        assertThat(list.size(), is(0));

        list.addLast(1).addLast(1).addLast(1);
        assertThat(list.size(), is(3));
    }

    /**
     * ************************************************
     * リスト削除系のテスト
     * *************************************************
     */
    @Test
    public void 削除の基本動作確認() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.addLast(1).addLast(2);
        list.removeLast();
        assertThat(list.toString(), is("SinglyLinkedList{1}"));
        list.removeLast();
        assertThat(list.toString(), is("SinglyLinkedList{}"));

        list.addLast(1).addLast(2);
        list.removeFirst();
        assertThat(list.toString(), is("SinglyLinkedList{2}"));
        list.removeFirst();
        assertThat(list.toString(), is("SinglyLinkedList{}"));

        list.addLast(1).addLast(2);
        list.removeLast();
        assertThat(list.toString(), is("SinglyLinkedList{1}"));
        list.removeLast();
        assertThat(list.toString(), is("SinglyLinkedList{}"));

        list.addLast(1).addLast(2);
        list.removeFirst();
        assertThat(list.toString(), is("SinglyLinkedList{2}"));
        list.removeFirst();
        assertThat(list.toString(), is("SinglyLinkedList{}"));

        list.addLast(1).addLast(2);
        list.removeFirst();
        assertThat(list.toString(), is("SinglyLinkedList{2}"));
        list.remove(0);
        assertThat(list.toString(), is("SinglyLinkedList{}"));
    }
}