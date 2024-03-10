package Hw3HashMap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Naomi Serkez
// 3.2024
//this is entirely my own (used previous tests from other projects as reference)
public class MapTest {
    @Test
        //checks basic functionality of adding pairs
    void correctlyAddsAndCountsPairs() {
        ArrayMap<String, String> map = new ArrayMap<>();
        map.put("HI", "GREETING");
        map.put("Hello", "GREETING");
        map.put("yes?", "GREETING");
        int expected = 3;
        int actual = map.size();
        assertEquals(expected, actual);
    }

    @Test
        //make sure doesnt add same thing twice
    void correctlyAddsAndCountsPairs2() {
        ArrayMap<String, String> map = new ArrayMap<>();
        map.put("HI", "GREETING");
        map.put("Hello", "GREETING");
        map.put("yes?", "GREETING");
        map.put("yes?", "GREETING");
        map.put("yes?", "GREETING");
        int expected = 3;
        int actual = map.size();
        assertEquals(expected, actual);
    }

    @Test
        //checks for adding int keys
    void correctlyAddsInts() {
        ArrayMap<Integer, String> map = new ArrayMap<>();
        map.put(433, "GREETING1");
        map.put(8765, "GREETING2");
        map.put(654, "GREETING3");
        String expected = "GREETING1";
        String actual = map.get(433);
        assertEquals(expected, actual);
    }

    @Test
        //tests that you can add bool values correctly
    void correctlyAddsBools() {
        ArrayMap<String, Boolean> map = new ArrayMap<>();
        map.put("HI", false);
        map.put("Hello", true);
        map.put("yes?", false);
        boolean expected = false;
        boolean actual = map.get("HI");
        assertEquals(expected, actual);
    }

    @Test
        //tests that you cannot add a null key
    void doesNotAddNullKey() {
        ArrayMap<String, String> map = new ArrayMap<>();
        map.put(null, "GREETING");
        map.put("Hello", "GREETING");
        map.put("yes?", "GREETING");
        int expected = 2;
        int actual = map.size();
        assertEquals(expected, actual);
    }

    @Test
        //tests that adding the same thing twice will change the value
    void correctlyUpdatesValue() {
        ArrayMap<String, Integer> map = new ArrayMap<>();
        map.put("Hello", 1);
        map.put("Hello", 56);
        int expected = 56;
        int actual = map.get("Hello");
        assertEquals(expected, actual);
    }
}
