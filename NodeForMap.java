public class NodeForMap<T,S> {
    private NodeForMap<T,S> nextNode;

    private T key;
    private S value;
    public NodeForMap(NodeForMap<T,S> nextNode, T key ,S value){
        this.nextNode =nextNode;

        this.value =value;
        this.key =key;
    }
    public NodeForMap<T,S> getNextElement(){
        return nextNode;
    }



    public void setNextElement(NodeForMap<T,S> nextNode){
        this.nextNode = nextNode;
    }
    public S getValue(){
        return (S) value;
    }
    public void setValue(S value){
        this.value = value;
    }
    public T getKey(){
        return key;
    }
    public void setKey(T key){
        this.key = key;
    }
}
