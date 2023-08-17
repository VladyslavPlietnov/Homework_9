import java.util.Arrays;

public class MyArrayList<T> {
    private int size = 0;
    private static final int DEFAULT_SIZE = 10;
    private Object elements[];

    public void check(int index) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
    }

    public MyArrayList() {
        elements = new Object[DEFAULT_SIZE];
    }

    public MyArrayList(int capacity) {
        elements = new Object[capacity];
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        check(index);
        return (T) elements[index];
    }

    private void adjustSize() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(T element) {
        if (size == elements.length) {
            adjustSize();
        }
        elements[size] = element;
        size++;
    }

    public T remove(int index) {
        check(index);
        Object item = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return (T) item;
    }


    public void clear() {
        elements = new Object[DEFAULT_SIZE];
        size = 0;
    }

}
