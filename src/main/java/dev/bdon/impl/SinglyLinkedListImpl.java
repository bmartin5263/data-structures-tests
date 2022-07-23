package dev.bdon.impl;


import dev.bdon.list.List;
import dev.bdon.list.linked.singly.Node;
import dev.bdon.list.linked.singly.SinglyLinkedList;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedListImpl<T> implements SinglyLinkedList<T> {

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
            head = new Node<>(data, head);
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
            tail.setNext(new Node<>(data, null));
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
            Node<T> before = head;
            while (before.getNext() != tail) {
                before = before.getNext();
            }
            tail = before;
            before.setNext(null);
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
            before.setNext(new Node<>(data, before.getNext()));
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

        if (head.getData().equals(o)) {
            if (head == tail) {
                head = null;
                tail = null;
            }
            else {
                head = head.getNext();
            }
            --size;
            return true;
        }

        Node<T> before = head;
        while (before.getNext() != null) {
            var nextData = before.getNext().getData();
            if (o.equals(nextData)) {
                before.setNext(before.getNext().getNext());
                if (before.getNext() == null) {
                    tail = before;
                }
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
        if (index == 0) {
            popFront();
        }
        else if (index == size() - 1) {
            popBack();
        }
        else {
            --size;
            Node<T> before = head;
            int count = 1;
            while (count != index) {
                before = before.getNext();
                ++count;
            }
            before.setNext(before.getNext().getNext());
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
