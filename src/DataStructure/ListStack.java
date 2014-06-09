package DataStructure;

/**
 * Stack implementation
 * @param <E> type
 */
public class ListStack<E> {
    private Node<E> top;
    private int size = 0;

    /**
     * dataをスタックに挿入する
     * @param data 挿入したいデータ
     */
    public void push(E data) {
        Node<E> n = new Node<E>(data, top);
        top = n;
        size++;
    }

    /**
     * スタックのトップにある要素を取り出す
     * @return スタックのトップにあったデータ
     */
    public E pop() {
        if(top == null)
            return null;

        E item = top.item;
        top = top.next;
        size--;
        return item;
    }

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

    public ListStack(E... args){
        // not implemented
    }

    /**
     * Code Interview Chapter 3: Question 2
     * pushとpopに加えて、最小の要素を返す関数minを持つスタックをどのようにデザインしますか？
     * ただし、push, pop, min関数はすべてO(1)の実行時間になるようにしてください。
     */
    public Integer min(){
        // your code goes here
        return 0;
    }
}
