import java.util.AbstractList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
public class MyArrayList<T> {
    private int size = 0;
    private static final int defaultSize= 10;
    private Object elements[];

    public MyArrayList() {
        elements = new Object[defaultSize];
    }
    public MyArrayList(int capacity) {
        elements = new Object[capacity];
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (T) elements[index];
    }
    private void adjustSize() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(T element) {

        adjustSize();

        elements[size] = element;

        size++;
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
          int a = size;
       for(int i=a-1; i>=0; i--){

           elements[i]=elements[i+1];
            size--;
       }

    }

}
