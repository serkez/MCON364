package Hw3HashMap;

import java.util.*;
import java.util.function.Function;

//Naomi Serkez
// 3.2024
//this is a combination of the book, sonfoundry and my own work
public class ArrayMap<K, V> implements MapInterface<K, V> {
    //variables
    private MapEntry<K, V>[] map;
    private final int DEFCAP = 5000;
    private final double DEFLOAD = 0.75;
    private int origCap;
    private int currCap;
    private double load;
    private int numPairs = 0;
    Function<K, Integer> currHash; //stores the users choice of hash as a lambda
    //simple hash
    Function<K, Integer> hash1 = key -> key.hashCode() % currCap < 0 ? key.hashCode() % currCap + currCap : key.hashCode() % currCap;

    // 'complex' hash, for the sake of lambdas. I did not have a second function before, so I just repeated
    Function<K, Integer> hash2 = key -> key.hashCode() % currCap < 0 ? key.hashCode() % currCap + currCap : key.hashCode() % currCap;
    Map<String, Function<K, Integer>> functionMap = new HashMap<>(); //will store the hashes, needs to be in a function so done in constructor


    //default constructor
    public ArrayMap() {
        map = new MapEntry[DEFCAP];
        origCap = DEFCAP;
        currCap = DEFCAP;
        load = DEFLOAD;
        functionMap.put("1", hash1);
        functionMap.put("2", hash2);
    }

    //overloaded constructor
    public ArrayMap(int initCapacity, double initLoad, String hash) {
        map = new MapEntry[initCapacity];
        origCap = initCapacity;
        currCap = initCapacity;
        load = initLoad;
        functionMap.put("1", hash1);
        functionMap.put("2", hash2);
        setHash(hash);
    }
    //allows user to set the hash function
    public void setHash(String h){
        currHash = functionMap.get(h);
    }
    //make array bigger
    private void enlarge() {
        Iterator<MapEntry<K, V>> i = iterator();
        int count = numPairs;
        map = new MapEntry[currCap + origCap];
        currCap = currCap + origCap;
        numPairs = 0;
        MapEntry entry;
        for (int n = 1; n <= count; n++) {
            entry = i.next();
            this.put((K) entry.getKey(), (V) entry.getValue());
        }
    }

    //function to put a pair in the hashMap
    public void put(K k, V v) {
        if (k == null) return; //doesn't accept null keys
        int location = currHash.apply(k) % currCap; //decides location based on hash function and size of array
        if (map[location] == null) { //if nothing is there, put this key value pair
            map[location] = new MapEntry<>(k, v);
            numPairs++;
        } else { //if it is occupied...
            MapEntry<K, V> entry = map[location];
            //traverse down the linked list until either the key is null or the key is the same sa teh one you are inserting
            while (entry.next != null && !entry.key.equals(k)) {
                entry = entry.next;
            }
            if (entry.key.equals(k)) { //if key is the same, update value
                entry.value = v;
            } else { //if null, place new key value pair
                entry.next = new MapEntry<>(k, v);
                numPairs++;
            }

        }
    }

    //returns the value that is paired to a specified key
    public V get(K k) {
        if (k == null) throw new IllegalArgumentException("Maps do not allow null keys.");
        for (MapEntry<K, V> temp : map) {
            if (temp != null) {
                if (temp.getKey().equals(k)) return temp.getValue();
            }
        }
        return null;
    }

    //removes a key value pair (not used)
    public V remove(K k) {
        if (k == null) throw new IllegalArgumentException("Maps do not allow null keys.");
        MapEntry<K, V> temp;
        Iterator<MapEntry<K, V>> search = iterator();
        while (search.hasNext()) {
            temp = search.next();
            if (temp != null) {
                if (temp.getKey().equals(k)) {
                    search.remove();
                    return temp.getValue();
                }
            }
        }
        return null;
    }

    //checks if a key exists in the map, returns true/false
    public boolean contains(K k) {
        if (k == null) throw new IllegalArgumentException("Maps do not allow null keys.");
        for (MapEntry<K, V> temp : map) {
            if (temp != null) {
                if (temp.getKey().equals(k)) return true;
            }
        }
        return false;
    }

    //checks if the map is empty
    public boolean isEmpty() {
        return (map == null);
    }

    //checks if map is full, not relevent here becasue we use linked lists that cant get full
    public boolean isFull() {
        return false;
    }

    //returns the number of pairs in the map
    public int size() {
        return numPairs;
    }

    //returns number of unused slots
    public int unused() {
        int unusedSlots = 0;
        for (MapEntry<K, V> temp : map) {
            if (temp == null) {
                unusedSlots++;
            }
        }
        return unusedSlots;
    }


    //hash method. I know its not ideal, but its what I had time for
/*    private int hashMethod(K key) {
        int hashVal = key.hashCode();
        hashVal %= currCap;
        if (hashVal < 0) hashVal += currCap;
        return hashVal;
    }*/




    public int sizeArray() {
        return currCap;
    }

    // Function to print hash table
    public void printHashTable() {
        for (int i = 0; i < currCap; i++) {
            System.out.print("\nBucket " + (i + 1) + " : ");
            MapEntry<K, V> entry = map[i];
            while (entry != null) {
                System.out.print(entry.key + " ");
                System.out.print(entry.value + " ");
                entry = entry.next;
            }
        }
    }
    public void sizeLinkedList() {
        for (int i = 0; i < currCap; i++) {
            System.out.print("\nBucket " + (i + 1) + " size of linked list: ");
            MapEntry<K, V> entry = map[i];
            int counter =0;
            while (entry != null) {
                counter++;
                entry = entry.next;
            }
            System.out.print(counter);
        }
    }

private class MapIterator implements Iterator<MapEntry<K, V>> {
    int listSize = size();
    private MapEntry[] list = new MapEntry[listSize];
    private int previousPos = -1; // previous position returned from list

    public MapIterator() {
        int next = -1;
        for (int i = 0; i < listSize; i++) {
            next++;
            while (map[next] == null) next++;
            list[i] = map[next];
        }
    }

    public boolean hasNext() {
        return (previousPos < (listSize - 1));
    }

    public MapEntry<K, V> next() {
        if (!hasNext()) throw new IndexOutOfBoundsException("illegal invocation of next " + " in HMap iterator.\n");
        previousPos++;
        return list[previousPos];
    }

    public void remove() {
        throw new UnsupportedOperationException("Unsupported remove attempted " + "on HMap iterator.\n");
    }

}

    public Iterator<MapEntry<K, V>> iterator() {
        return new MapIterator();
    }
}

