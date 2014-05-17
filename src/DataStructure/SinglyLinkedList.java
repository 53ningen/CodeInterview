package DataStructure;

/**
 * Created by yuki_yanagi on 2014/05/17.
 */

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

    private int size;    // リストの要素数
    private Node first = null;   // リストの先頭要素を指すポインタ
    private Node last  = null;   // リストの最後尾を指すポインタ

    /**
     * 与えられた整数値がリストのインデックスとして有効か判断する
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
     * @param index 欲しいNodeの位置を表す整数
     * @return 要求されたNode
     * @throws IndexOutOfBoundsException
     */
    private Node<E> node(int index){
        if(!isPositionIndex(index)) throw new IndexOutOfBoundsException();

        Node<E> current = first;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current;
    }

    /**
     * 単方向リストを横断して要素数を返す
     * 時間計算量:O(n)
     * 空間計算量:0(1)
     * @param head 横断を始めるノード
     * @return 要素数
     */
    private int length(Node<E> head) {
        Node<E> current = head;
        if(current == null) return 0;

        int count = 1;
        while(current != null && current.next != null){
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * リストの先頭からカウントして、全体の要素数を返す
     * @return
     */
    public int size() {
        return length(first);
    }

    /**
     * リストのプロパティsizeに格納されている要素数を返す
     * @return
     */
    public int size_property() {
        return size;
    }

    /***************************************************
     * 単一連結リストの挿入
     ***************************************************/
    /**
     * リストに要素を追加する
     * 時間計算量:O(1)
     * 空間計算量:O(1)
     * @param element 追加したい要素
     * @return 追加後のリスト
     */
    public SinglyLinkedList add(E element) {
        if(last == null) {
            // リストが空だったとき
            this.first = new Node<E>(element, null);
            this.last  = first;
        }
        else {
            this.last.next = new Node<E>(element, null);
            this.last = this.last.next;
        }
        return this;
    }

    /**
     * リストの先頭に要素を追加する
     * @param element 追加したい要素
     * @return 追加後のリスト
     */
    public SinglyLinkedList addFirst(E element) {
        if(last == null) {
            //リストが空だったとき
            add(element);
        }
        else {
            this.first = new Node<E>(element, this.first);
        }
        return this;
    }

    /**
     * リストの末尾に要素を追加する
     * @param element 追加したい要素
     * @return 追加後のリスト
     */
    public SinglyLinkedList addLast(E element) {
        add(element);  // addと動作は同じ
        return this;
    }

    /**
     * 指定されたノードに新しい要素のノードをリンクする
     * @param node リンク元のノード
     * @param element リンクを張りたい要素
     */
    private void link(Node<E> node, E element) {
        Node<E> newNode = new Node<E>(element, node.next);
        node.next = newNode;
    }

    /**
     * リストの指定位置に要素を追加する
     * @param index 要素を追加したい位置
     * @param element 追加したい要素
     * @return 追加後のリスト
     * @throws IndexOutOfBoundsException
     */
    public SinglyLinkedList add(int index, E element) {
        if(!isPositionIndex(index)) throw new IndexOutOfBoundsException();
        if(index == size) return add(element);
        if(index == 0) return addFirst(element);

        Node<E> beforeNewNode = node(index - 1);
        link(beforeNewNode, element);
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
