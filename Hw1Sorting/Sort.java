package Hw1Sorting;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//Naomi Serkez
//2.2024
//this class contains the 2 sorting methods as well as main
public class Sort {
    //Quick Sort
    public static <T extends Comparable> void quickSort(ArrayList<T> list, int begin, int end) {
        if (begin < end) {
            System.out.println("List's current order: " + list);
            System.out.println("Sorting: " + list.subList(begin, end + 1));
            System.out.println("***calling partition method***");
            int partitionIndex = partition(list, begin, end); //calls partition method
            System.out.println("***calling quickSort method***");
            quickSort(list, begin, partitionIndex - 1); //recursive call for first half of list
            System.out.println("***calling quickSort method***");
            quickSort(list, partitionIndex + 1, end); // recursive call for second half of list
        }
    }

    //partition method
    //this is where the actual sorting happens
    public static <T extends Comparable> int partition(ArrayList<T> list, int begin, int end) {
        T pivot = list.get(end); //sets pivot to last element in current partition
        System.out.println("Pivot: " + pivot);
        int i = (begin - 1);
        //checks all elements against pivot
        //if the element is less than pivot, i is moved up one and i and j are swappped
        for (int j = begin; j < end; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;
                System.out.println("Current sublist:");
                System.out.println(list.subList(begin, end + 1));
                System.out.println("Swapping: " + list.get(i) + " with " + list.get(j));
                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                System.out.println(list.subList(begin, end + 1));
            }
        }
        //after pivot is compared to all elements, pivot is placed in its appropriate location
        System.out.println("Moving pivot:");
        T temp = list.get(i + 1);
        list.set(i + 1, list.get(end));
        list.set(end, temp);
        System.out.println(list.subList(begin, end + 1));
        return i + 1;
    }

    //Merge Sort
    public static <T extends Comparable<T>> void mergeSort(ArrayList<T> list, int size) {
        if (size < 2) return;
        int mid = size / 2;
        ArrayList<T> left = new ArrayList<>(); //creates array for left half of list
        for (int i = 0; i < mid; i++)
            left.add(list.get(i));
        System.out.println("left list: " + left);
        ArrayList<T> right = new ArrayList<>();//creates array for right half of list
        for (int i = mid; i < size; i++)
            right.add(list.get(i));
        System.out.println("right list" + right);

        //recursively calls method on either side of list until all lists are of length 1, then calls merge
        System.out.println("***Calling mergeSort method***");
        mergeSort(left, mid);
        System.out.println("***Calling mergeSort method***");
        mergeSort(right, size - mid);
        System.out.println("***Calling merge method***");
        merge(list, left, right, mid, size - mid);
    }

    //merge method is where all teh "lists" are put back together while sorting them
    public static <T extends Comparable<T>> void merge(ArrayList<T> list, ArrayList<T> left, ArrayList<T> right, int l, int r) {
        int i = 0, j = 0, k = 0;
        while (i < l && j < r) {
            System.out.println("Comparing: " + left.get(i) + " to " + right.get(j));
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }
        while (i < l) {
            list.set(k++, left.get(i++));
            System.out.println("Current list: " + list.subList(0, k));
        }
        while (j < r) {
            list.set(k++, right.get(j++));
            System.out.println("Current list: " + list.subList(0, k));
        }
    }

    //main
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        ArrayList<Student> list = new ArrayList<>();
        System.out.println("How many Students would you like to sort?");
        try {
            int numStudents = Integer.parseInt(input.next());
            System.out.println("Would you like an auto generated list of grades?(y/yes for yes, any other key for no)");
            String line = input.next();
            if (line.equalsIgnoreCase("y") || line.equalsIgnoreCase("yes")) {
                for (int i = 1; i <= numStudents; i++) {
                    list.add(new Student("Student" + i, r.nextInt(40, 101)));
                }
            } else {
                System.out.println("Enter " + numStudents + " grades. (one per line)");
                for (int i = 1; i <= numStudents; i++) {
                    String inp = input.next();
                    if (Integer.parseInt(inp) < 0 || Integer.parseInt(inp) > 100) {
                        System.out.println("Not a valid grade, try again");
                    }
                    list.add(new Student("Student" + i, Integer.parseInt(inp)));
                }
            }

            ArrayList<Student> sortedWithQuick = (ArrayList<Student>) list.clone();
            ArrayList<Student> sortedWithMerge = (ArrayList<Student>) list.clone();

            System.out.println("Unsorted list: ");
            System.out.println(list);
            System.out.println();

            Sort.quickSort(sortedWithQuick, 0, sortedWithQuick.size() - 1);
            System.out.println();
            System.out.println("*****quickSort complete*****");
            System.out.println();
            System.out.println("List sorted with quickSort: ");
            System.out.println(sortedWithQuick);

            System.out.println();
            System.out.println("***Starting mergeSort***");
            Sort.mergeSort(sortedWithMerge, sortedWithMerge.size());
            System.out.println();
            System.out.println("List sorted with mergeSort: ");
            System.out.println(sortedWithQuick);
        } catch (NumberFormatException e) {
            System.out.println("Not a valid number");
        }
    }
}
