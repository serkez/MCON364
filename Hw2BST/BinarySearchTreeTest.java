package Hw2BST;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
//Naomi Serkez
//2.2024

class BinarySearchTreeTest {
    @Test
    void insertIntNode() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(54);
        tree.add(3);
        tree.add(24);
        tree.add(43);
        tree.add(29);
        String expected = "54, 3, 24, 43, 29, ";
        String actual = tree.toString();
        assertEquals(expected, actual);

    }

    @Test
    void insertIntNode2() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(54);
        tree.add(3);
        tree.add(432);
        tree.add(87);
        tree.add(29);
        String expected = "54, 3, 432, 29, 87, ";
        String actual = tree.toString();
        assertEquals(expected, actual);

    }

    //true > false
    @Test
    void insertBoolNode() {
        BinarySearchTree<Boolean> tree = new BinarySearchTree<>();
        tree.add(true);
        tree.add(false);
        tree.add(false);
        tree.add(true);
        tree.add(true);
        String expected = "true, false, false, true, true, ";
        String actual = tree.toString();
        assertEquals(expected, actual);

    }

    //spaces count. They have an ascii value, so more spaces > less spaces
    @Test
    void insertEmptyNode() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.add("    ");
        tree.add("");
        tree.add("  ");
        tree.add("     ");
        tree.add(" ");
        String expected = "    , ,      ,   ,  , ";
        String actual = tree.toString();
        assertEquals(expected, actual);

    }

    //I learned that lowercase letters are "more" that uppercase
    @Test
    void insertStringNode() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.add("Hello");
        tree.add("Hi");
        tree.add("whatsUP");
        tree.add("apple");
        tree.add("AHHHH");
        String expected = "Hello, AHHHH, Hi, whatsUP, apple, ";
        String actual = tree.toString();
        assertEquals(expected, actual);

    }

    //leading zeros are ignored
    @Test
    void insertLinkedListNode() {
        BinarySearchTree<Double> tree = new BinarySearchTree<>();
        tree.add(000000.01);
        tree.add(0.02);
        tree.add(000.03);
        tree.add(.04);
        tree.add(00.05);
        String expected = "0.01, 0.02, 0.03, 0.04, 0.05, ";
        String actual = tree.toString();
        assertEquals(expected, actual);

    }

}