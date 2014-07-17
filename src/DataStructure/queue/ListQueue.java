package DataStructure.queue;

/**
 * Queue implementation.
 * キューのリストを使った実装
 * @param <E> type
 */
public class ListQueue<E> extends Queue<E> {
    Node<E> head;
    Node<E> tail;

    int size = 0;
    @Override public int size() { return size; }
    @Override public boolean isEmpty() { return head == null; }

    /**
     * Queueのノード
     * @param <E> 要素の型
     */
    private class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next){
            this.item = item;
            this.next = next;
        }
    }

    /**
     * ListQueueのコンストラクタ
     */
    public ListQueue(){}
    public ListQueue(E... elements) {
        for(E e: elements) {
            enqueue(e);
        }
    }

    /**
     * 要素をキューする
     * @param e 要素
     */
    @Override
    public void enqueue(E e) {
        if(isEmpty()) {
            head = tail = new Node<E>(e, null);
        }
        else {
            tail.next = new Node<E>(e, null);
            tail = tail.next;
        }
        size++;
    }

    /**
     * 要素をデキューする
     * @return 要素
     */
    @Override
    public E dequeue() {
        if(isEmpty() return null;

        E ret;
        ret = head.item;
        head = head.next;
        size--;
        /* リストが空になった */
        if(isEmpty()) tail = null;
        return ret;
    }
}
