package Hw1Sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
//Naomi Serkez
//2.2024
//this class contains the unit tests
class SortTest {

    @Test
    void quickSortStudent() {
        Student a = new Student("a", 90);
        Student b = new Student("b", 85);
        Student c = new Student("c", 97);
        Student d = new Student("d", 85);
        Student e = new Student("e", 76);
        ArrayList<Student> actual= new ArrayList<>();
        actual.add(a);
        actual.add(b);
        actual.add(c);
        actual.add(d);
        actual.add(e);
        ArrayList<Student> expected =new ArrayList<>();
        expected.add(e);
        expected.add(b);
        expected.add(d);
        expected.add(a);
        expected.add(c);
        Sort.quickSort(actual, 0, actual.size()-1);
        assertEquals(expected, actual);
    }
    @Test
    void quickSortInt() {
        Integer a= 90;
        Integer b= 4;
        Integer c= 4340;
        Integer d= 464;
        Integer e= 76;
        Integer f= 11;

        ArrayList<Integer> actual= new ArrayList<>();
        actual.add(a);
        actual.add(b);
        actual.add(c);
        actual.add(d);
        actual.add(e);
        actual.add(f);
        ArrayList<Integer> expected =new ArrayList<>();
        expected.add(b);
        expected.add(f);
        expected.add(e);
        expected.add(a);
        expected.add(d);
        expected.add(c);
        Sort.quickSort(actual, 0, actual.size()-1);
        assertEquals(expected, actual);
    }
    @Test
    void mergeSortStudent() {
        Student a = new Student("a", 90);
        Student b = new Student("b", 85);
        Student c = new Student("c", 97);
        Student d = new Student("d", 85);
        Student e = new Student("e", 76);
        ArrayList<Student> actual= new ArrayList<>();
        actual.add(a);
        actual.add(b);
        actual.add(c);
        actual.add(d);
        actual.add(e);
        ArrayList<Student> expected =new ArrayList<>();
        expected.add(e);
        expected.add(b);
        expected.add(d);
        expected.add(a);
        expected.add(c);
        Sort.mergeSort(actual, actual.size());
        assertEquals(expected, actual);
    }
    @Test
    void mergeSortString() {
        String a = "Hey there!";
        String b = "Whats up?";
        String c = "Ahhhh";
        ArrayList<String> actual= new ArrayList<>();
        actual.add(a);
        actual.add(b);
        actual.add(c);
        ArrayList<String> expected =new ArrayList<>();
        expected.add(c);
        expected.add(a);
        expected.add(b);
        Sort.mergeSort(actual, actual.size());
        assertEquals(expected, actual);
    }

}