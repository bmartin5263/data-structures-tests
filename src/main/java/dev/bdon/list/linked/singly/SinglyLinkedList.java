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
    default T[] toArray() {
        int count = 0;
        Node<T> current = head();
        while (current != null) {
            ++count;
            current = current.getNext();
        }
        T[] arr = (T[]) new Comparable[count];

        count = 0;
        current = head();
        while (current != null) {
            arr[count++] = current.getData();
            current = current.getNext();
        }

        return arr;
    }
}
