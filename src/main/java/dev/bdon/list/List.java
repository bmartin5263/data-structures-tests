package dev.bdon.list;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public interface List<T> extends Iterable<T> {

    /**
     * Gets the item at the given index
     *
     * @throws IndexOutOfBoundsException if index is < 0 OR index >= size()
     */
    T get(int index);

    /**
     * Adds an item to front of the list where list[0] is considered the front
     */
    void pushFront(T data);

    /**
     * Adds an item to back of the list where list[size() - 1] is considered the back
     */
    void pushBack(T data);

    /**
     * Remove the item at the front of the list where list[0] is considered the front
     *
     * @throws NoSuchElementException if size() == 0
     */
    T popFront();

    /**
     * Remove the item at back of the list where list[size() - 1] is considered the back
     *
     * @throws NoSuchElementException if size() == 0
     */
    T popBack();

    /**
     * Retrieves, but does not remove, the item at the front of the list where list[0] is considered the front
     *
     * @throws NoSuchElementException if size() == 0
     */
    T peekFront();

    /**
     * Retrieves, but does not remove, the item at back of the list where list[size() - 1] is considered the back
     *
     * @throws NoSuchElementException if size() == 0
     */
    T peekBack();

    /**
     * Inserts an item into the given index of the list, shifting all items to the right (back) to accommodate the
     * new item
     *
     * @throws IndexOutOfBoundsException if index is < 0 OR index > size()
     */
    void insert(int index, T data);

    /**
     * Sets the value at specified index to the given value in the list. No new items are added, the size
     * should be the same after
     *
     * @throws IndexOutOfBoundsException if index is < 0 OR index >= size()
     */
    void set(int index, T data);

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
    @Override
    Iterator<T> iterator();

    /**
     * Removes the first-occurrence of a given item from the list.
     * Returns true if the item existed and was removed, false if otherwise
     */
    boolean remove(T o);

    /**
     * Removes the item at the given index from the list.
     *
     * @throws IndexOutOfBoundsException if index is < 0 OR index >= size()
     */
    void removeAt(int index);

    /**
     * Deletes all items from the list
     */
    void clear();

    /**
     * Walks the list to return a fixed-sized array of all the items in the list.
     */
    @SuppressWarnings("unchecked")
    default T[] toArray() {
        int count = 0;
        Iterator<T> current = iterator();
        while (current.hasNext()) {
            ++count;
            current.next();
        }
        T[] arr = (T[]) new Comparable[count];

        count = 0;
        current = iterator();
        while (current.hasNext()) {
            arr[count++] = current.next();
        }

        return arr;
    }
}
