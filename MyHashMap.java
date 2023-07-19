import java.util.*;
public class MyHashMap<T,S> {
private int defaultBucketAmount = 5;
private int bucketAmount;
private Bucket<T,S>[] buckets;
public MyHashMap(){
    Bucket<T,S>[] buckets = new Bucket[defaultBucketAmount];
    for(int i = 1; i <=defaultBucketAmount;i++){
        buckets[i] = new Bucket<T,S>();
    }
    bucketAmount = defaultBucketAmount;
    }
    public void generateMoreBuckets(){
        bucketAmount *=2;
        buckets = Arrays.copyOf(buckets, bucketAmount);
    }

public void put(T key, S value){
    boolean toMuch = true;
    for(Bucket<T,S> bucket:buckets){
        toMuch = toMuch&&(bucket.getSize()>=50);
    }
    if(toMuch){generateMoreBuckets();}

    int a = key.hashCode();
    int rest = a%bucketAmount;
   boolean presentInMap = false;
    for(Bucket<T,S> bucket:buckets){
        if(bucket.getNumber()==rest){
            NodeForMap<T,S> node = bucket.getFirstNode();
            for( int i =0; i<bucket.getSize()-1;i++){
                if(a == node.getKey().hashCode()){
                   node.setValue(value);
                   presentInMap = true;
                   break;
                }
                node = node.getNextElement();
            }
            if(!presentInMap){
                bucket.add(key, value);
            }
            break;
        }

    }
}

public S get(T key){
    S value = null;
    int a = key.hashCode();
    int rest = a%bucketAmount;
    for(Bucket<T,S> bucket:buckets){
        if(bucket.getNumber()==rest){
            NodeForMap<T,S> node = bucket.getFirstNode();
            for( int i =0; i<bucket.getSize()-1;i++){
                if(a == node.getKey().hashCode()){
                    value = node.getValue();
                }
                node = node.getNextElement();
            }
            break;
        }
    }
    return value;
}

public int size(){
    int size = 0;
    for(Bucket<T,S> bucket:buckets){
        size += bucket.getSize();
    }
    return size;
}
public void remove(T key){
    int a = key.hashCode();
    int rest = a%bucketAmount;
    for(Bucket<T,S> bucket:buckets){
        if(bucket.getNumber()==rest){
            NodeForMap<T,S> node = bucket.getFirstNode();
            if( a == node.getKey().hashCode()){
                node.setNextElement(null);
            }
            for( int i =0; i<bucket.getSize()-1;i++){
                if(a == node.getNextElement().getKey().hashCode()){
                    node.setNextElement(node.getNextElement().getNextElement());
                    node.getNextElement().setNextElement(null);
                }

                node = node.getNextElement();
            }
            break;
        }
    }
}

public void clear(){
    for(Bucket<T,S> bucket:buckets){
        NodeForMap<T,S> node = bucket.getFirstNode();
        for( int i =0; i<bucket.getSize()-1;i++){
            T k = node.getKey();
            node = node.getNextElement();
            remove(k);
        }
    }
}

}
