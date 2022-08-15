package dev.bdon.map;

import java.util.Iterator;

public interface Map<K, V> extends Iterable<Entry<K, V>> {

    /**
     * Add a key-value entry into the map
     */
    void put(K key, V value);

    /**
     * Retrieve the value associated with the given key
     */
    V get(K key);

    /**
     * Returns the number of entries in the Map
     */
    int size();

    /**
     * Returns true if this Map has zero entries, false if otherwise.
     *
     * Note - if map.size() returns 0, then map.isEmpty() should also be returning true
     */
    boolean isEmpty();

    /**
     * Returns true if this Map contains the given key, false if otherwise
     */
    boolean containsKey(K key);

    /**
     * Returns true if this Map contains the given value, false if otherwise
     */
    boolean containsValue(V value);

    /**
     * Returns true if this Map contains the given key-value pair, false if otherwise
     */
    boolean containsEntry(K key, V value);

    /**
     * Returns an iterator for the entries in this Map
     */
    @Override
    Iterator<Entry<K, V>> iterator();

    /**
     * Removes the entry with the given key from the Map.
     * Returns true if the entry existed and was removed, false if otherwise
     */
    boolean remove(K key);

    /**
     * Removes the entry with the given key & value from the Map.
     * Returns true if the entry existed and was removed, false if otherwise
     */
    boolean remove(K key, V value);
}
