package DataStructure.queue;

/**
 * Queue implementation.
 * キューの配列を使った実装
 * @param <E> type
 */
public class ArrayQueue<E> extends Queue<E> {
    private final Object[] values;
    private final ArrayIndex head;
    private final ArrayIndex tail;

    /**
     * コンストラクタ．
     * キューのサイズを指定しない場合は100がデフォルト値となる．
     * @param size キューのサイズ指定
     */
    public ArrayQueue(int size) {
        this.head = new ArrayIndex(-1, size);
        this.tail = new ArrayIndex(-1, size);
        values = new Object[size];
    }
    public ArrayQueue() {
        this(100);
    }

    @Override
    public void enqueue(E e) {
        values[tail.getNext()] = e;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E dequeue() {
        if(isEmpty()) return null;
        return (E)values[head.getNext()];
    }

    @Override
    public boolean isEmpty() {
        return head.index == tail.index;
    }

    @Override
    public int size() {
        if(tail.index >= head.index)
            return tail.index - head.index;
        else
            return head.size - head.index + tail.index;
    }

    class ArrayIndex {
        final int size;
        int index;
        ArrayIndex(int index, int size) {
            this.index = index;
            this.size = size;
        }
        // example:
        // index = 0, size = 3: getNext() -> 1
        // index = 1, size = 3: getNext() -> 2
        // index = 2, size = 3: getNext() -> 0
        int getNext() {
            index = (index + 1) % size;
            return index;
        }
    }
}
