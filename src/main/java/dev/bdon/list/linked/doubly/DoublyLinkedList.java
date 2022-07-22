package dev.bdon.list.linked.doubly;

import dev.bdon.list.List;

public interface DoublyLinkedList<T> extends List<T> {
    /**
     * Returns the node at the front of the list
     */
    Node<T> head();

    /**
     * Returns the node at the back of the list
     */
    Node<T> tail();

    /**
     * Removes the given node from the list. This should be done without walking the list
     */
    void remove(Node<T> node);
}
