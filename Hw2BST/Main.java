package Hw2BST;

import java.util.Random;
import java.util.Scanner;

//Naomi Serkez
//2.2024
public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want an auto generated experience? (y for 'yes' and any other key for 'no')");
        //created random generated tree and randomly adds and removes random values
        if (input.next().equalsIgnoreCase("y")) {
            Random rndm = new Random();
            for (int i = 0; i < rndm.nextInt(10, 21); i++) {
                tree.add(rndm.nextInt(0, 50));
                System.out.println("Tree: " + tree);
            }
            for (int i = 0; i < rndm.nextInt(5, 11); i++) {
                if (rndm.nextInt(0, 2) == 0) {
                    tree.add(rndm.nextInt(0, 50));
                    System.out.println("Tree: " + tree);
                } else {
                    tree.remove(rndm.nextInt(0, 50));
                    System.out.println("Tree: " + tree);
                }
            }
            for (int i = 0; i < rndm.nextInt(5, 11); i++) {
                if (rndm.nextInt(0, 2) == 0) {
                    int look = rndm.nextInt(0, 50);
                    System.out.print("Looking for " + look );
                    tree.contains(look);
                    System.out.println("Tree: " + tree);
                } else {
                    System.out.println(tree.size());
                    System.out.println("Tree: " + tree);
                }
            }
        } else { //user manipulated tree
            System.out.println("Enter: 'add', 'remove', 'contains', 'size', 'min', or 'max'");
            String s = input.next();
            while (!s.equalsIgnoreCase("Stop")) {
                if (s.equalsIgnoreCase("add")) {
                    System.out.println("Enter a number to add:");
                    String inp = input.next();
                    try {
                        tree.add(Integer.parseInt(inp));
                        System.out.println("Tree: " + tree);
                    } catch (NumberFormatException e) {
                        System.out.println("Not a valid number");
                        System.out.println("Tree: " + tree);
                    }
                } else if (s.equalsIgnoreCase("remove")) {
                    System.out.println("Enter a number to remove:");
                    String inp = input.next();
                    try {
                        tree.remove(Integer.parseInt(inp));
                        System.out.println("Tree: " + tree);
                    } catch (NumberFormatException e) {
                        System.out.println("Not a valid number");
                        System.out.println("Tree: " + tree);
                    }
                }
                else if (s.equalsIgnoreCase("contains")) {
                    System.out.println("Which number are you looking for in the tree:");
                    String inp = input.next();
                    try {
                        tree.contains(Integer.parseInt(inp));
                        System.out.println("Tree: " + tree);
                    } catch (NumberFormatException e) {
                        System.out.println("Not a valid number");
                        System.out.println("Tree: " + tree);
                    }
                }
                else if (s.equalsIgnoreCase("size")) {
                    System.out.println("The tree has " + tree.size() + " nodes");
                }
                else if (s.equalsIgnoreCase("min")) {
                    System.out.println("The tree's minimum value is ' " + tree.min());
                }
                else if (s.equalsIgnoreCase("max")) {
                    System.out.println("The tree's maximum value is ' " + tree.max());
                }else {
                    System.out.println("Invalid request");
                    System.out.println("Tree: " + tree);
                }
                s = input.next();
            }
        }
    }
}
