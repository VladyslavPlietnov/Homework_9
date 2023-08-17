import java.util.*;

public class MyHashMap<T, S> {
    private int DEFAULT_BUCKET_AMOUNT = 5;
    private int bucketAmount;
    private Bucket<T, S>[] buckets;
    private int size = 0;


    public MyHashMap() {
        buckets = new Bucket[DEFAULT_BUCKET_AMOUNT];
        for (int i = 1; i <= DEFAULT_BUCKET_AMOUNT; i++) {
            buckets[i - 1] = new Bucket<T, S>();

        }
        bucketAmount = DEFAULT_BUCKET_AMOUNT;
    }

    public void generateMoreBuckets() {
        bucketAmount += DEFAULT_BUCKET_AMOUNT;
        buckets = Arrays.copyOf(buckets, bucketAmount);
        for (int i = bucketAmount - DEFAULT_BUCKET_AMOUNT - 1; i < bucketAmount; i++) {
            buckets[i] = new Bucket<>();
        }
    }

    public void put(T key, S value) {
        int a = key.hashCode();
        int rest = a % bucketAmount;

        boolean toMuch = true;
//        for (Bucket<T, S> bucket : buckets) {
//            System.out.println(bucket.getSize());
//            toMuch = toMuch && (bucket.getSize() >= 50);
//        }
//        if (toMuch) {
//            generateMoreBuckets();
//        }


        boolean presentInMap = false;

        for (int i = 0; i < buckets.length; i++) {
            if (i == rest) {
                if (buckets[i].getSize() < 50) {
                    NodeForMap<T, S> node = buckets[i].getFirstNode();
                    for (int j = 0; j < buckets[i].getSize() - 1; j++) {
                        if (a == node.getKey().hashCode()) {
                            node.setValue(value);
                            presentInMap = true;
                            break;
                        }
                        node = node.getNextElement();
                    }
                    if (!presentInMap) {
                        buckets[i].add(key, value);
                        size++;
                    }
                    break;
                } else {
                    generateMoreBuckets();
                    put(key, value);
                }
            }

        }
    }

    public S get(T key) {
        S value = null;
        int a = key.hashCode();
        for (int m = bucketAmount / DEFAULT_BUCKET_AMOUNT; m > 0; m--) {
            int rest = a % (m * DEFAULT_BUCKET_AMOUNT);

            for (int i = 0; i < buckets.length; i++) {
                if (i == rest) {
                    NodeForMap<T, S> node = buckets[i].getFirstNode();
                    for (int j = 0; j < buckets[i].getSize(); j++) {

                        if (a == node.getKey().hashCode()) {
                            value = node.getValue();
                        }
                        node = node.getNextElement();
                    }
                    break;
                }
            }
            if (value != null) break;
        }
        return value;
    }

    public int size() {
        return size;
    }

    public void remove(T key) {
        int a = key.hashCode();
        int rest = a % bucketAmount;
        for (int i = 0; i < buckets.length; i++) {
            if (i == rest) {
                NodeForMap<T, S> node = buckets[i].getFirstNode();
//                System.out.println(i);
//                System.out.println(bucketAmount);
//                System.out.println(buckets[i].getSize());
                if (a == node.getKey().hashCode()) {
                    buckets[i].setFirstNode(node.getNextElement());
                    node.setNextElement(null);
                } else {
                    for (int j = 0; j < buckets[i].getSize() - 1; j++) {
//                        System.out.println(j);
//                        System.out.println(a +"::"+node.getNextElement().getKey().hashCode());
                        if (a == node.getNextElement().getKey().hashCode()) {
                            node.setNextElement(node.getNextElement().getNextElement());
                            //node.getNextElement().setNextElement(null);
                            break;
                        }

                        node = node.getNextElement();
                    }
                }
                size--;

                break;
            }
        }
    }

    public void clear() {
        size = 0;
        buckets = new Bucket[DEFAULT_BUCKET_AMOUNT];
    }

}
