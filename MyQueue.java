import java.util.Arrays;


public class MyQueue<T> {
    private int size = 0;
    private static final int DEFAULT_SIZE = 10;
    private Object elements[];

    public MyQueue() {
        elements = new Object[DEFAULT_SIZE];
    }

    public MyQueue(int capacity) {
        elements = new Object[capacity];
    }

    public int size() {
        return size;
    }


    private void adjustSize() {
        int newSize = elements.length + DEFAULT_SIZE;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(T element) {

        if (size == elements.length) {
            adjustSize();
        }

        elements[size] = element;


        size++;
    }

    public T poll() {

        Object item = elements[0];
        for (int i = 0; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return (T) item;
    }

    public T peek() {
        return (T) elements[0];
    }


    public void clear() {
        elements = new Object[DEFAULT_SIZE];
        size = 0;
    }

}
