package DataStructure;

import DataStructure.queue.Queue;

import java.util.Stack;

public class MyQueue<T> extends Queue<T> {
    Stack<T> enqueueStack = new Stack<T>();
    Stack<T> dequeueStack = new Stack<T>();
    private int size = 0;

    @Override
    public void enqueue(T t) {
        enqueueStack.add(t);
        size++;
    }

    @Override
    public T dequeue() {
        // 要素を持っていないとき
        if(enqueueStack.empty() && dequeueStack.empty())
            return null;

        if(dequeueStack.empty()) {
            while(!enqueueStack.empty())
                dequeueStack.add(enqueueStack.pop());
        }

        size--;
        return dequeueStack.pop();
    }

    public int size() {
        return size;
    }
}
