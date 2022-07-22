package dev.bdon.list.linked.doubly;

public class Node<T> {
    private T data;
    private Node<T> next;
    private Node<T> prev;

    Node() {
        this(null, null);
    }

    Node(T data) {
        this(data, null);
    }

    Node(T data, Node<T> next) {
        this(data, next, null);
    }

    Node(T data, Node<T> next, Node<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
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

    public Node<T> getPrev() {
        return prev;
    }

    void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "Node(" +
                "data=" + data +
                ')';
    }
}
