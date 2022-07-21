package dev.bdon.interfaces;

import java.util.Iterator;

public interface SinglyLinkedList<T extends Comparable<T>> extends Iterable<T> {

    interface Node<T> {
        T getData();
        Node<T> getNext();
        void setNext(Node<T> node);
    }

    /**
     * Adds an item to front of the list where list[0] is considered the front
     */
    void pushFront(T data);

    /**
     * Adds an item to back of the list where list[size() - 1] is considered the back
     */
    void pushBack(T data);

    /**
     * Inserts an item to the specified position in the list.
     *
     * @throws IndexOutOfBoundsException if pos is < 0 OR pos > size() + 1
     */
    void insert(int pos, T data);

    /**
     * Returns the node of the front of the list
     */
    Node<T> head();

    /**
     * Returns the number of items in the list
     */
    int size();

    /**
     * Returns true if this list has zero items, false if otherwise.
     *
     * Note - if list.size() returns 0, then list.isEmpty() should also be returning true
     */
    boolean isEmpty();

    /**
     * Returns true if this list contains the given item, false if otherwise
     */
    boolean contains(T o);

    /**
     * Returns an iterator for the items in this list
     */
    Iterator<T> iterator();

    /**
     * Removes the first-occurrence of a given item from the list.
     * Returns true if the item existed and was removed, false if otherwise
     */
    boolean remove(T o);

    /**
     * Deletes all items from the list
     */
    void clear();

    /**
     * Returns the maximum item in the list as defined by its compareTo() method
     */
    T max();

    /**
     * Returns the minimum item in the list as defined by its compareTo() method
     */
    T min();

    /**
     * Walks the list to return a fixed-sized array of all the items in the list.
     */
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
