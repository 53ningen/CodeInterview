package DataStructure;

/**
 * Stack implementation
 * @param <E> type
 */
public class Stack<E> {
    /**
     * Stackのノード
     * @param <E> type
     */
    class Node<E>{
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node<E> first;
    private int size = 0;

    public Stack(E... args){
        // not implemented
    }
}
