package dev.bdon.impl;


import dev.bdon.list.linked.doubly.DoublyLinkedList;
import dev.bdon.list.linked.doubly.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedListImpl<T> implements DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public T get(int index) {
        assertInBounds(index, size() - 1);
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
        if (isEmpty()) {
            Node<T> n = new Node<>(data);
            head = n;
            tail = n;
        }
        else {
            head.setPrev(new Node<>(data, head));
            head = head.getPrev();
        }
        ++size;
    }

    @Override
    public void pushBack(T data) {
        if (isEmpty()) {
            Node<T> n = new Node<>(data);
            head = n;
            tail = n;
        }
        else {
            tail.setNext(new Node<>(data, null, tail));
            tail = tail.getNext();
        }
        ++size;
    }

    @Override
    public T popFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        else {
            --size;
            Node<T> out = head;
            if (head == tail) {
                head = null;
                tail = null;
            }
            else {
                head = head.getNext();
                head.setPrev(null);
            }
            return out.getData();
        }
    }

    @Override
    public T popBack() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        --size;
        Node<T> out = tail;
        if (tail == head) {
            head = null;
            tail = null;
        }
        else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        return out.getData();
    }

    @Override
    public T peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.getData();
    }

    @Override
    public T peekBack() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.getData();
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
            before.setNext(new Node<>(data, before.getNext(), before));
            ++size;
        }
    }

    @Override
    public void set(int index, T data) {
        assertInBounds(index, size() - 1);
        Node<T> current = head;
        int count = 0;
        while (count < index) {
            ++count;
            current = current.getNext();
        }
        current.setData(data);
    }

    @Override
    public Node<T> head() {
        return head;
    }

    @Override
    public Node<T> tail() {
        return tail;
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

        Node<T> current = head;
        while (current != null) {
            var data = current.getData();
            if (o.equals(data)) {
                if (current == head) {
                    popFront();
                }
                else if (current == tail) {
                    popBack();
                }
                else {
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                    --size;
                }
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    @Override
    public void removeAt(int index) {
        assertInBounds(index, size() - 1);
        if (index == 0) {
            popFront();
        }
        else if (index == size() - 1) {
            popBack();
        }
        else {
            --size;
            Node<T> current = head.getNext();
            int count = 1;
            while (count != index) {
                current = current.getNext();
                ++count;
            }
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
        }
    }

    private void assertInBounds(int index, int upperBound) {
        if (index < 0 || index > upperBound) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}
