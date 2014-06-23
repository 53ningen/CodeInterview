package DataStructure;

/**
 * Stack implementation
 * @param <E> type
 */
public class ArrayStack<E> {
    private int top = -1;
    private int size = 0;

    private Object[] array;
    private int stackMaxSize;

    public ArrayStack(int stackMaxSize) {
        this.stackMaxSize = stackMaxSize;
        array = new Object[stackMaxSize];
    }

    /**
     * ArrayStackのコンストラクタ．
     * argsの長さがstackMaxSizeよりも大きい場合，
     * argsの長さ分の配列が確保される
     * @param stackMaxSize stackの最大長
     * @param args stackの初期化要素
     */
    public ArrayStack(int stackMaxSize, E... args) {
        if(args.length < stackMaxSize)
            stackMaxSize = args.length;

        this.stackMaxSize = stackMaxSize;
        array = new Object[stackMaxSize];

        for(E arg: args)
            this.push(arg);
    }

    /**
     * dataをスタックに挿入する
     * @param data 挿入したいデータ
     */
    public void push(E data) {
        if(size >= stackMaxSize)
            throw new StackOverflowError();

        array[++top] = data;
        size++;
    }

    /**
     * スタックのトップにある要素を取り出す
     * @return スタックのトップにあったデータ
     */
    @SuppressWarnings("unchecked")
    public E pop() {
        if(size < 1)
            return null;

        size--;
        return (E)array[top--];
    }
}
