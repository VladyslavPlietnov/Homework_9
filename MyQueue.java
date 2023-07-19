import java.util.Arrays;
import java.util.Collection;

public class MyQueue<T>  {
    private int size = 0;
    private static final int defaultSize= 10;
    private Object elements[];
    public MyQueue() {
        elements = new Object[defaultSize];
    }
    public MyQueue(int capacity) {
        elements = new Object[capacity];
    }

    public int size() {
        return size;
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

    public T poll() {

        Object item = elements[0];
        for (int i = 0; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return (T) item;
    }

    public T peek(){
        return (T) elements[0];
    }


    public void clear(){
        for(Object item:elements){
            poll();
        }
    }

}
