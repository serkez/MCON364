package Hw3HashMap;

//Naomi Serkez
// 3.2024
//this is primarily copied from the book

public interface MapInterface<K, V> extends Iterable<MapEntry<K, V>> {
    void put(K k, V v);

    V get(K k);

    V remove(K k);

    boolean contains(K k);

    boolean isEmpty();

    boolean isFull();

    int size();
}
