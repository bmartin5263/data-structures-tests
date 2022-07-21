package dev.bdon.impl;

import dev.bdon.interfaces.SinglyLinkedList;

import java.util.Iterator;

public class SinglyLinkedListImpl<T extends Comparable<T>> implements SinglyLinkedList<T> {

    private Node<T> head;
    private int size;

    @Override
    public void pushFront(T data) {
        head = new NodeImpl<>(data, head);
        ++size;
    }

    @Override
    public void pushBack(T data) {
        if (head == null) {
            pushFront(data);
        }
        else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new NodeImpl<>(data));
            ++size;
        }
    }

    @Override
    public void insert(int pos, T data) {
        if (pos == 0) {
            pushFront(data);
        }
        else if (pos == size()) {
            pushBack(data);
        }
        else {
            int count = pos - 1;
            Node<T> before = head;
            while (count > 0) {
                before = before.getNext();
                --count;
            }
            before.setNext(new NodeImpl<>(data, before.getNext()));
            ++size;
        }
    }

    @Override
    public Node<T> head() {
        return head;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T o) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(o)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                var out = current;
                current = current.getNext();
                return out.getData();
            }
        };
    }

    @Override
    public boolean remove(T o) {
        if (isEmpty()) {
            return false;
        }

        if (head.getData().equals(o)) {
            head = head.getNext();
            --size;
            return true;
        }

        Node<T> before = head;
        while (before.getNext() != null) {
            var nextData = before.getNext().getData();
            if (o.equals(nextData)) {
                before.setNext(before.getNext().getNext());
                --size;
                return true;
            }
            before = before.getNext();
        }

        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public T max() {
        if (isEmpty()) {
            return null;
        }

        var currentMax = head.getData();
        var current = head.getNext();

        while (current != null) {
            if (current.getData().compareTo(currentMax) > 0) {
                currentMax = current.getData();
            }
            current = current.getNext();
        }

        return currentMax;
    }

    @Override
    public T min() {
        if (isEmpty()) {
            return null;
        }

        var currentMin = head.getData();
        var current = head.getNext();

        while (current != null) {
            if (current.getData().compareTo(currentMin) < 0) {
                currentMin = current.getData();
            }
            current = current.getNext();
        }

        return currentMin;
    }

    public static class NodeImpl<T extends Comparable<T>> implements Node<T> {

        private final T data;
        private Node<T> next;

        public NodeImpl(T data) {
            this(data, null);
        }

        public NodeImpl(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public T getData() {
            return data;
        }

        @Override
        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
