package dev.bdon.map.tree;

import dev.bdon.map.Map;

public interface TreeMap<K extends Comparable<K>, V> extends Map<K, V> {

    Node<K, V> root();

    K maxKey();

    K minKey();

}
