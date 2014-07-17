package DataStructure.queue;

public abstract class Queue<E> {
    public abstract void enqueue(E e);
    public abstract E dequeue();
    public abstract boolean isEmpty();
    public int size() {
        throw new UnsupportedOperationException();
    }
}
