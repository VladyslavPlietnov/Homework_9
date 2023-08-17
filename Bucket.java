public class Bucket<T, S> {
    private NodeForMap<T, S> firstNode;


    public int size = 0;

    public Bucket(NodeForMap<T, S> firstNode) {
        this.firstNode = firstNode;

    }

    public Bucket() {
        firstNode = null;
    }

    public void setFirstNode(NodeForMap<T, S> firstNode) {
        this.firstNode = firstNode;
    }


    public NodeForMap<T, S> getFirstNode() {
        return firstNode;
    }

    public void add(T key, S value) {
        if (firstNode == null) {
            firstNode = new NodeForMap(null, key, value);
        } else {
            NodeForMap<T, S> node = firstNode;
            while (node.getNextElement() != null) {
                node = node.getNextElement();
            }

            NodeForMap<T, S> inputNode = new NodeForMap<>(null, key, value);
            node.setNextElement(inputNode);

        }
        size++;
    }

    public int getSize() {
        return size;
    }


}
