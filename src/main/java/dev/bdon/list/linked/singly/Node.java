package dev.bdon.list.linked.singly;

public class Node<T> {
    private T data;
    private Node<T> next;

    Node() {
        this(null, null);
    }

    Node(T data) {
        this(data, null);
    }

    Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node(" +
                "data=" + data +
                ')';
    }
}
