package dev.bdon.map;

import java.util.Iterator;

public interface Map<K, V> extends Iterable<Entry<K, V>> {

    void put(K key, V value);

    V get(K key);

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
    boolean containsKey(K key);

    /**
     * Returns true if this list contains the given item, false if otherwise
     */
    boolean containsValue(V value);

    /**
     * Returns an iterator for the items in this list
     */
    @Override
    Iterator<Entry<K, V>> iterator();

    /**
     * Removes the first-occurrence of a given item from the list.
     * Returns true if the item existed and was removed, false if otherwise
     */
    boolean remove(K key);

    /**
     * Removes the first-occurrence of a given item from the list.
     * Returns true if the item existed and was removed, false if otherwise
     */
    int removeAllWithValue(V values);
}
