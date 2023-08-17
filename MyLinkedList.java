

public class MyLinkedList<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    public int size = 0;

    public void add(T value) {
        if (firstNode == null) {
            firstNode = new Node<>(null, null, value);
        } else if (lastNode == null) {
            lastNode = new Node<>(firstNode, null, value);
            firstNode.setNextElement(lastNode);
        } else {

            Node<T> node = new Node<>(lastNode, null, value);
            lastNode.setNextElement(node);
            lastNode = node;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public int indexOf(T value) {
        int index = 0;
        Node node = firstNode;
        while (!node.getValue().equals(value) && index < (size - 1)) {
//            System.out.println(node.getValue() +"=" + value);
//            System.out.println(node.getValue().equals(value));
//            System.out.println(node.getValue().getClass() + " "+ value.getClass());
            index++;
            node = node.getNextElement();
        }
        return index;
    }

    public T get(int index) {
        Node node = firstNode;
        while (indexOf((T) node.getValue()) != index) {
            node = node.getNextElement();
        }
        return (T) node.getValue();
    }

    public Node<T> getNode(int index) {
        Node node = firstNode;
        while (indexOf((T) node.getValue()) != index) {
            node = node.getNextElement();
        }
        return node;
    }

    public void remove(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size :" + index);
        }
        Node node = getNode(index);
        Node leftNode = getNode(index - 1);
        Node rightNode = getNode(index + 1);
        leftNode.setNextElement(rightNode);
        rightNode.setPreviousElement(leftNode);
        node.setNextElement(null);
        node.setPreviousElement(null);
        size--;
    }

    public void clear() {
        firstNode.setNextElement(null);
        lastNode.setPreviousElement(null);
        size = 0;
    }
}
