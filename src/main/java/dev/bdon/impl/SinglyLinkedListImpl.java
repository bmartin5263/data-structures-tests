package dev.bdon.impl;


import dev.bdon.list.List;
import dev.bdon.list.linked.singly.Node;
import dev.bdon.list.linked.singly.SinglyLinkedList;

import java.util.Comparator;
import java.util.Iterator;

public class SinglyLinkedListImpl<T> implements SinglyLinkedList<T> {

    private Node<T> head;
    private int size;

    @Override
    public T get(int index) {
        assertInBounds(index, size());
        Node<T> current = head;
        int count = 0;
        while (count != index) {
            current = current.getNext();
            ++count;
        }
        return current.getData();
    }

    @Override
    public void pushFront(T data) {
        head = new Node<>(data, head);
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
            current.setNext(new Node<>(data));
            ++size;
        }
    }

    @Override
    public void insert(int index, T data) {
        assertInBounds(index, size());
        if (index == 0) {
            pushFront(data);
        }
        else if (index == size()) {
            pushBack(data);
        }
        else {
            int count = index - 1;
            Node<T> before = head;
            while (count > 0) {
                before = before.getNext();
                --count;
            }
            before.setNext(new Node<>(data, before.getNext()));
            ++size;
        }
    }

    @Override
    public void set(int index, T data) {
        assertInBounds(index, size());
    }

    @Override
    public Node<T> head() {
        return head;
    }

    @Override
    public Node<T> tail() {
        return null;
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
    public void removeAt(int index) {
        assertInBounds(index, size() - 1);
    }

    private void assertInBounds(int index, int upperBound) {
        if (index < 0 || index > upperBound) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public T max(Comparator<T> comparator) {
        if (isEmpty()) {
            return null;
        }

        var currentMax = head.getData();
        var current = head.getNext();

        while (current != null) {
            if (comparator.compare(current.getData(), currentMax) > 0) {
                currentMax = current.getData();
            }
            current = current.getNext();
        }

        return currentMax;
    }

    @Override
    public T min(Comparator<T> comparator) {
        if (isEmpty()) {
            return null;
        }

        var currentMin = head.getData();
        var current = head.getNext();

        while (current != null) {
            if (comparator.compare(current.getData(), currentMin) < 0) {
                currentMin = current.getData();
            }
            current = current.getNext();
        }

        return currentMin;
    }
}
