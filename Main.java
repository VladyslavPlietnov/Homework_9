public class Main {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("hello");
        list.add("java");
        list.add("world");
        list.add( "lol");

        System.out.println(list.size());
        System.out.println(list.get(1));
        System.out.println(list.remove(2));
        System.out.println(list.size());
        list.clear();
        System.out.println(list.size());

    }
}