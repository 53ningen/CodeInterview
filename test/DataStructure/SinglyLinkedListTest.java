package DataStructure;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SinglyLinkedListTest {
    /***************************************************
     * リスト挿入系のテスト
     ***************************************************/
    @Test
    public void いろんな型でadd操作(){
        SinglyLinkedList<String> stringList = new SinglyLinkedList<String>();
        stringList.add("hello").add(" ").add("world");
        assertThat(stringList.toString(), is("SinglyLinkedList{hello, ,world}"));
    }

    @Test
    public void 単純なadd操作に対するtoStringの動作確認() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.add(1);
        assertThat(list.toString(), is("SinglyLinkedList{1}"));

        list.add(2).add(3).add(4);
        assertThat(list.toString(), is("SinglyLinkedList{1,2,3,4}"));
    }

    @Test
    public void 正しくaddされるか() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();

    }

    @Test
    public void add系の各メソッドに対して要素数を正しく反映できているか() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        assertThat(list.size(), is(0));
        assertThat(list.size_property(), is(0));

        list.add(1).add(1).add(1);
        assertThat(list.size(), is(3));
        //assertThat(list.size_property(), is(3));
    }

    /***************************************************
     * リスト削除系のテスト
     ***************************************************/
    @Test
    public void 削除の基本動作確認() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.add(1).add(2);
        list.removeLast();
        assertThat(list.toString(), is("SinglyLinkedList{1}"));
        list.removeLast();
        assertThat(list.toString(), is("SinglyLinkedList{}"));

        list.add(1).add(2);
        list.removeFirst();
        assertThat(list.toString(), is("SinglyLinkedList{2}"));
        list.removeFirst();
        assertThat(list.toString(), is("SinglyLinkedList{}"));
    }
}