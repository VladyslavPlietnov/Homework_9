import java.util.*;
public class MyStack<T> {
    private int size = 0;
    private static final int defaultSize= 10;
    private Object elements[];

    public MyStack() {
        elements = new Object[defaultSize];
    }
    public MyStack(int capacity) {
        elements = new Object[capacity];
    }

    public int size() {
        return size;
    }
    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size :" + index);
        }
        Object item = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return (T) item;
    }
    public void clear(){
        for(int i =0; i<size-1;i++){
            remove(i);
        }
    }
    public T peek(){
        return (T) elements[0];
    }
    public T pop() {

        Object item = elements[0];
        for (int i = 0; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return (T) item;
    }
    private void adjustSize() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public void push(T element) {

        adjustSize();

        elements[size] = element;


        size++;
    }
}
