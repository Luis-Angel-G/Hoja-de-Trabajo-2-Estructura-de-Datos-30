public class Node<T> {
    Node<T> next = null;
    Node<T> previous = null;
    T value;

    public Node(T value) {
        this.next = null;
        this.previous = null;
        this.value = value;
    }

    public Node() {
        this.next = null;
        this.previous = null;
        this.value = null;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public T getValue() {
        return value;
    }
}