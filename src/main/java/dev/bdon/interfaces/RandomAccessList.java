package dev.bdon.interfaces;

import java.util.Iterator;

public interface RandomAccessList<T extends Comparable<T>> {

    /**
     * Adds an item to front of the list where list[0] is considered the front
     */
    void pushFront(T data);

    /**
     * Adds an item to back of the list where list[size() - 1] is considered the back
     */
    void pushBack(T data);

    /**
     * Inserts an item to the specified position in the list, shifting all elements over to accommodate the
     * new item
     *
     * @throws IndexOutOfBoundsException if pos is < 0 OR pos > size() + 1
     */
    void insert(int pos, T data);

    /**
     * Sets the value at specified position to the given value in the list. No new items are added
     *
     * @throws IndexOutOfBoundsException if pos is < 0 OR pos >= size()
     */
    void set(int pos, T data);

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
     * Removes the item at the given index from the list.
     *
     * @throws IndexOutOfBoundsException if pos is < 0 OR pos >= size()
     */
    boolean removeAtIndex(int index);

    /**
     * Deletes all items from the list
     */
    void clear();

    /**
     * Sorts the list in-place
     */
    void sort();

    /**
     * Returns a new list based on the current list in sorted order
     */
    RandomAccessList<T> sorted();

}
