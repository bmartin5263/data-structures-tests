package dev.bdon.list.linked.singly;

import dev.bdon.list.List;
import dev.bdon.list.linked.singly.Node;

public interface SinglyLinkedList<T> extends List<T> {
    /**
     * Returns the node at the front of the list
     */
    Node<T> head();

    /**
     * Returns the node at the back of the list
     */
    Node<T> tail();
}
