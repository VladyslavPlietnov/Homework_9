public class Node<T> {
    private Node<T> nextNode;
    private Node<T> previousNode;
    private T value;

    public Node(Node<T> nextNode, Node<T> previousNode, T value) {
        this.nextNode = nextNode;
        this.previousNode = previousNode;
        this.value = value;
    }

    public Node<T> getNextElement() {
        return nextNode;
    }

    public Node<T> getPreviousElement() {
        return previousNode;
    }

    public void setPreviousElement(Node<T> previousNode) {
        this.previousNode = previousNode;
    }

    public void setNextElement(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public T getValue() {
        return (T) value;
    }
}
