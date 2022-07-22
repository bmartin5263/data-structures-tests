package dev.bdon.map.tree;

import dev.bdon.map.Entry;

public class Node<K extends Comparable<K>, V> {
    private Entry<K, V> data;
    private Node<K, V> left;
    private Node<K, V> right;

    public Node() {
    }

    public Node(Entry<K, V> data, Node<K, V> left, Node<K, V> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node<K, V> getLeft() {
        return left;
    }

    public void setLeft(Node<K, V> left) {
        this.left = left;
    }

    public Node<K, V> getRight() {
        return right;
    }

    public void setRight(Node<K, V> right) {
        this.right = right;
    }

    public Entry<K, V> getData() {
        return data;
    }

    public void setData(Entry<K, V> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node(" +
                "data=" + data +
                ')';
    }
}
