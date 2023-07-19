public class Bucket<T,S> {
    private NodeForMap<T,S> firstNode;
    private int number=0;

    public Bucket (NodeForMap<T,S> firstNode){
        this.firstNode = firstNode;
        number++;
    }
    public Bucket (){
        number++;
    }
    public void setFirstNode(NodeForMap<T,S> firstNode){
        this.firstNode = firstNode;
    }
    public int getNumber(){
        return number;
    }
    public NodeForMap<T,S> getFirstNode(){
        return firstNode;
    }

    public void add(T key, S value){
        if(firstNode == null){
            firstNode = new NodeForMap(null, key, value);
        }

        else{
            NodeForMap<T,S> node = firstNode;
          while(node!=null){
              node = node.getNextElement();
          }

            NodeForMap<T,S> inputNode = new NodeForMap<>(null, key, value);
            node.setNextElement(inputNode);

        }
    }

    public int getSize(){
        int size =0;
        NodeForMap<T,S> node = firstNode;
        while(node!=null){
            node = node.getNextElement();
            size++;
        }
        return size;
    }




}
