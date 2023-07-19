public class Main {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add(0,"hello");
        list.add(1,"java");
        list.add(2,"world");
        System.out.println(list.size());
        System.out.println(list.get(1));
        System.out.println(list.remove(1));
        System.out.println(list.size());
        list.clear();
        System.out.println(list.size());

    }
}