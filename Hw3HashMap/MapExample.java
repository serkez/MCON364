package Hw3HashMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

//Naomi Serkez
// 3.2024
//this is mostly my own work. I used references to figure out how to retrieve the text from the book
public class MapExample {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayMap<String, Integer> map = new ArrayMap<>();
        Scanner input = new Scanner(System.in);
        String inp;
        //here got user input and then set the hash
        //if -else is just for validation, not for fuctionality
        System.out.println("Enter '1' for simple hash function and '2' for complex:");
        inp = input.next();
        if(inp.equals("1") || inp.equals("2")){
            map.setHash(inp);
        }
        else{
            System.out.println("Invalid option, defaulting to simple hash function");
            map.setHash("1");
        }
        //retreives every word from the book by scanning each word in, and putting it into a string
        Scanner scanner = new Scanner(new File("Hw3HashMap/frankenstein.txt"));
        String book = scanner.useDelimiter("\\A").next();
        //cleans up words by removing extra charachters
        book = book.replace(".", " ");
        book = book.replace("(", " ");
        book = book.replace(")", " ");
        book = book.replace(":", " ");
        book = book.replace("--", " ");
        book = book.replace("!", " ");
        book = book.replace("?", " ");
        book = book.replace(",", " ");
        book = book.replace(";", " ");
        book = book.replace("...", " ");
        book = book.replace("\"", " ");
        book = book.replace("'", " ");
        String[] splitBook = book.split(" +"); //delimiter is one or more spaces
        //adds each word to map
        for (int i = 0; i < splitBook.length; i++) {
            splitBook[i] = splitBook[i].toLowerCase().trim();
            if (map.contains(splitBook[i])) { //if already there, increase v by 1
                map.put(splitBook[i], map.get(splitBook[i]) + 1);
            } else { //if new word, add
                map.put(splitBook[i], 1);
            }
        }

        System.out.println("Would you like to:(enter number) \n 0- Exit \n 1- View map(raw) \n 2- view map in descending order of usage \n 3- get the number of unique words \n 4- get the number of unused slots \n 5- get word count for word \n 6- get report");
        do {
            inp = input.next();
            switch (inp) {
                case "0" -> System.out.println("Bye!");
                case "1" -> map.printHashTable();
                case "2" -> {
                    //needs work
                    System.out.println("Sorry, this feature has not been developed yet. try again later!");
                }
                case "3" -> {
                    System.out.println(map.size());
                }
                case "4" -> {
                    System.out.println(map.unused());
                }
                case "5" -> {
                    System.out.println("enter word:");
                    String word = input.next().toLowerCase();
                    if (map.contains(word)) System.out.println(map.get(word));
                    else System.out.println("Word not found");
                }
                case "6" -> {
                    System.out.println("word count: " + splitBook.length);
                    System.out.println("size of array: " + map.sizeArray());
                    System.out.println("unused slots: " + map.unused());
                    System.out.println("map: " );
                    map.printHashTable();
                    System.out.println("map's linked lists sizes: " );
                    map.sizeLinkedList();

                }
                default -> System.out.println("Bad request");
            }
        } while (!inp.equals("0"));

    }
}
