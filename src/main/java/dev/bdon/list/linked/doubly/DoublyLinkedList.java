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
}
