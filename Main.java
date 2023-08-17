import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add("" + i);
        }

        System.out.println(list.size());
        System.out.println(list.get(1));
        System.out.println(list.remove(2));
        System.out.println(list.size());

        MyLinkedList<Integer> intList = new MyLinkedList<>();
        for (int i = 0; i < 100000; i++) {
            intList.add(i);
        }
        System.out.println("for list:" + intList.size());
        System.out.println("for list:" + intList.indexOf(13498));
        System.out.println("for list:" + intList.get(24323));
        intList.remove(23432);
        System.out.println("for list:" + intList.size());
        intList.clear();
        // викидало помилку, бо я перевіряв, чи дійсно видалений список через метод get

        MyQueue<Integer> intQueue = new MyQueue<>();
        for (int i = 0; i < 100000; i++) {
            intQueue.add(i);
        }

        System.out.println("for queue:" + intQueue.poll());
        System.out.println("for queue:" + intQueue.peek());
        System.out.println("for queue:" + intQueue.size());
        intQueue.clear();


        MyStack<Integer> intStack = new MyStack<>();
        for (int i = 0; i < 100000; i++) {
            intStack.push(i);
        }
        System.out.println(intStack.pop());
        System.out.println(intStack.peek());
        System.out.println(intStack.size());
        intStack.clear();


        MyHashMap<Integer, String> intMap = new MyHashMap<>();
        for (int i = 0; i < 1000; i++) {
            intMap.put(i, "" + i);
        }

        System.out.println("size:" + intMap.size());
        System.out.println("value:" + intMap.get(279));
        intMap.remove(12);
        System.out.println("size:" + intMap.size());
        intMap.clear();


    }
}