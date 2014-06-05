package DataStructure;

import java.util.HashSet;
import java.util.Set;

/**
 * Singly-linked list implementation
 */
public class SinglyLinkedList<E> {
    /**
     * 単方向連結リストのノード
     * @param <E> 型
     */
    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    private int size = 0;
    private Node<E> first = null;   // リストの先頭要素を指すポインタ

    /**
     * コンストラクタ
     * @param args リストに追加したい要素
     */
    public SinglyLinkedList(E... args){
        for(E arg: args){
            this.addLast(arg);
        }
    }

    /**
     * 与えられた整数値がリストのインデックスとして有効か判断する
     *
     * @param index 判定する整数値
     * @return 与えられた整数値が有効であるのか
     */
    private Boolean isPositionIndex(int index) {
        return 0 <= index && index <= size;
    }

    /***************************************************
     * 連結リストを横断する
     ***************************************************/
    /**
     * 指定された位置のNodeを返す
     *
     * @param index 欲しいNodeの位置を表す整数
     * @return 要求されたNode
     * @throws IndexOutOfBoundsException
     */
    private Node<E> node(int index) {
        if (!isPositionIndex(index)) throw new IndexOutOfBoundsException();

        Node<E> current = first;
        for (int i = 0; i < index; i++)
            current = current.next;

        return current;
    }

    /**
     * 単方向リストを横断して要素数を返す
     * 時間計算量:O(n)
     * 空間計算量:0(1)
     *
     * @param head 横断を始めるノード
     * @return 要素数
     */
    private int length(Node<E> head) {
        Node<E> current = head;
        if (current == null) return 0;

        int count = 1;
        while (current.next != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * 全体の要素数を返す
     *
     * @return 要素数
     */
    public int size() {
        return size;
    }

    /**
     * リストの先頭からカウントして、全体の要素数を返す
     *
     * @return 要素数
     */
    public int length() {
        return length(first);
    }


    /***************************************************
     * ノードのlink・unlinkメソッド
     * 前後のnullチェックなどは行わず、
     * 低レベルのlink・unlinkのみを行う。
     ***************************************************/
    /**
     * 指定されたノードに新しい要素のノードをリンクする
     *
     * @param node     リンク元のノード
     * @param nextNode リンクを張りたいノード
     */
    private void link(Node<E> node, Node<E> nextNode) {
        node.next = nextNode;
    }

    /**
     * 与えられたノードが保持する、次のノードとアイテムへのポインタを削除する
     *
     * @param node リンクを断ち切りたいノード
     */
    private void unlink(Node<E> node) {
        node.item = null;
        node.next = null;
    }

    /***************************************************
     * 単一連結リストの挿入
     ***************************************************/
    /**
     * リストの先頭に要素を追加する
     * 時間計算量:O(1)
     * 空間計算量:O(1)
     *
     * @param element 追加したい要素
     * @return 追加後のリスト
     */
    public SinglyLinkedList<E> addFirst(E element) {
        if (first == null)
            first = new Node<E>(element, null); //リストが空だったとき
        else
            this.first = new Node<E>(element, this.first);

        size++;
        return this;
    }

    /**
     * リストの末尾に要素を追加する
     *
     * @param element 追加したい要素
     * @return 追加後のリスト
     */
    public SinglyLinkedList<E> addLast(E element) {
        if (size == 0) return addFirst(element);
        return add(size, element); // sizeのカウントアップはadd(int, E)で行う
    }

    /**
     * リストの指定位置に要素を追加する
     *
     * @param index   要素を追加したい位置
     * @param element 追加したい要素
     * @return 追加後のリスト
     * @throws IndexOutOfBoundsException
     */
    public SinglyLinkedList<E> add(int index, E element) {
        if (!isPositionIndex(index)) throw new IndexOutOfBoundsException();
        if (index == 0) return addFirst(element);

        Node<E> newNodePrev = node(index - 1);
        link(newNodePrev, new Node<E>(element, newNodePrev.next));

        size++;
        return this;
    }

    /***************************************************
     * 単一連結リストの削除
     ***************************************************/
    /**
     * リストの最初の要素を削除
     *
     * @return 削除後のリスト
     */
    public SinglyLinkedList<E> removeFirst() {
        if (first == null) return this;

        Node<E> next = first.next;
        unlink(first);
        first = next;
        size--;
        return this;
    }

    /**
     * リストの最後の要素を削除
     *
     * @return 削除後のリスト
     */
    public SinglyLinkedList<E> removeLast() {
        return remove(size - 1);
    }

    /**
     * 指定された位置の要素を削除する
     *
     * @param index 削除したい要素の位置
     * @return 削除後のリスト
     */
    public SinglyLinkedList<E> remove(int index) {
        if (first == null) return this;
        if (!isPositionIndex(index)) throw new IndexOutOfBoundsException();
        if (index == 0) return removeFirst();

        Node<E> removeNodePrev = node(index - 1);
        Node<E> removeNode = removeNodePrev.next;

        removeNodePrev.next = removeNode.next;
        unlink(removeNode);
        size--;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node<E> runner = this.first;
        while (runner != null) {
            sb.append(runner.item);
            if (runner.next == null)
                break;

            sb.append(",");
            runner = runner.next;
        }
        return String.format("SinglyLinkedList{size: %d, elements: [%s]}", size, sb.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SinglyLinkedList)) return false;
        SinglyLinkedList that = (SinglyLinkedList) o;

        if (size != that.size) return false;
        if (size == 0 && that.size == 0) return true;

        Node<E> current = first;
        Node<E> thatCurrent = that.first;
        while(current.next != null && thatCurrent.next != null){
            if(current.item != thatCurrent.item)
                return false;
            current = current.next;
            thatCurrent = thatCurrent.next;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + (first != null ? first.hashCode() : 0);
        return result;
    }

    /**
     * Code Interview Chapter 2: Question 1
     * ソートされていない連結リストから、重複する要素を削除するコードを書いてください
     */
    public SinglyLinkedList<E> removeDuplication(){
        // your codes goes here
        Set<E> nodes = new HashSet<E>();
        Node<E> current = this.first;
        Node<E> previous = null;

        if(current == null)
            return this;

        while(current != null) {
            if(nodes.contains(current.item)) {
                previous.next = current.next;
                size--;
            }
            else {
                nodes.add(current.item);
            }

            previous = current;
            current = current.next;
        }
        return this;

    }

    /**
     * Code Interview Chapter 2: Question 2
     * 単方向連結リストにおいて、末尾から数えてk番目の要素を見つけるアルゴリズムを実装してください
     */
    public E getNthToLast(int n){
        // your codes goes here
        if(n < 0 || n > size - 1) throw new IndexOutOfBoundsException();
        Node<E> current = first;
        int number = size - n - 1;

        while(number > 0) {
            current = current.next;
            number--;
        }
        return current.item;
    }

    /**
     * Code Interview Chapter 2: Question 3
     * 単方向連結リストにおいて、中央の要素のみアクセス可能であるとします。その要素を削除するアルゴリズムを実装してください。
     */
    public SinglyLinkedList<E> deleteCenterNode(){
        // your codes goes here
        // 中央の要素のみにしかアクセスできないという制約なのでまずは中央の要素をとる
        Node<E> centerNode = this.node( size >> 1 );
        if(centerNode.next == null) {
            this.first = null;
            this.size--;
            return this;
        }
        Node<E> centerNextNode = centerNode.next;

        if(centerNextNode != null) {
            centerNode.next = centerNextNode.next;
            centerNode.item = centerNextNode.item;
        }

        centerNextNode.item = null;
        centerNextNode.next = null;
        this.size--;
        return this;
    }

    /**
     * Code Interview Chapter 2: Question 4
     * ある数xが与えられたとき、連結リストの要素を並べ替え、xより小さいものが前にくるようにするコードを書いてください
     */
    public SinglyLinkedList<Integer> moveElementsToAheadLessThan(Integer x){
        // your codes goes here
        Node<E> current = first;
        if (current == null) return (SinglyLinkedList<Integer>)this;

        SinglyLinkedList<Integer> newValues = new SinglyLinkedList<Integer>();
        while (current.next != null) {
            if((Integer)current.item < x)
                newValues.addFirst((Integer)current.item);
            else
                newValues.addLast((Integer)current.item);


            current = current.next;
        }
        this.first = (Node<E>)newValues.first;
        this.size = newValues.size;

        return newValues;
    }
}
