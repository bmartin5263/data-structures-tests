package dev.bdon.list.linked.singly;

import dev.bdon.list.List;
import dev.bdon.list.linked.singly.Node;

import java.util.Iterator;

public interface SinglyLinkedList<T> extends List<T> {
    /**
     * Returns the node at the front of the list
     */
    Node<T> head();

    /**
     * Returns the node at the back of the list
     */
    Node<T> tail();

    @Override
    @SuppressWarnings("unchecked")
    default T[] toArray() {
        int size = 0;
        Node<T> current = head();
        while (current != null) {
            ++size;
            current = current.getNext();
        }
        T[] arr = (T[]) new Comparable[size];

        current = head();
        int index = 0;
        while (current != null) {
            arr[index++] = current.getData();
            current = current.getNext();
        }
        return arr;
    }
}
