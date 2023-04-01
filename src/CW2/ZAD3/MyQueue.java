package CW2.ZAD3;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyQueue<T> {
    private ArrayList<T> elements;

    public MyQueue(){
        this.elements = new ArrayList<>();
    }

    public void enqueue(T element){
        elements.add(element);
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException();

        T tmp = elements.get(0);
        elements.remove(tmp);
        return tmp;
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
