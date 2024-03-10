package Hw3HashMap;

//Naomi Serkez
// 3.2024
//this is primarily copied from the book

public class MapEntry<K, V> {
    protected K key;
    protected V value;
    protected MapEntry<K, V> next;

    MapEntry(K k, V v) {
        key = k;
        value = v;
        next = null;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V v) {
        value = v;
    }

    @Override
    public String toString() {
        return "Key: " + key + " Value " + value;
    }
}
