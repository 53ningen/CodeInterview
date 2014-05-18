package DataStructure;

/**
 * Singly-linked list implementation
 */
public class SinglyLinkedList<E> {
    /**
     * 単方向連結リストのノード
     *
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
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
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
        while (current != null && current.next != null) {
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

        Node<E> beforeNewNode = node(index - 1);
        link(beforeNewNode, new Node<E>(element, beforeNewNode.next));

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
        return String.format("SinglyLinkedList{%s}", sb.toString());
    }
}
