package HwLambdasAndStreams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        //creates default list of members
        ArrayList<SchulMember> members = getSchulMembers();

        int numFamilies = (int) members.stream().count(); //1
        //can really be replaced with this: int numFamilies = members.size();
        //But I left it for the sake of lambdas and streams

        System.out.println("Number of families belonging to the schul: " + numFamilies);

        //prints the members sorted by how long they have been a member
        System.out.println();
        System.out.println("Members by membership length:");
        members.stream().sorted(Comparator.comparingInt((SchulMember::getYearsOfMembership))).forEach((System.out::println)); //2

        //prints members by age in ascending order
        System.out.println();
        System.out.println("Members by age:(youngest to oldest)");
        members.stream().sorted(SchulMember::compareTo).forEach(member -> System.out.println(member.getFirstNameOfMember() + " " + member.getLastNameOfMember())); //3

        //prints wife's names in alphabetical order
        System.out.println();
        System.out.println("Wife's names, sorted:");
        members.stream().sorted(Comparator.comparing((SchulMember::getSpouseFirstName))).forEach(member -> System.out.println(member.getSpouseFirstName())); //4

        //prints families with more than 3 children
        System.out.println();
        System.out.println("Families with more than 3 children:");
        members.stream().filter(member -> member.getChildrenNames().length > 3).forEach(System.out::println); //5

        //prints all the kids whos name starts with any letter past 'c'
        //I got some guidance from chatgpt for this one, after failing to understand how to turn array of array into one
        //flatMap is similar to the selectMany lambda property I learned in C#, so I really could've figured it out...
        System.out.println();
        System.out.println("Children with 'big' names:");
        members.stream().flatMap(member -> Arrays.stream(member.getChildrenNames()).filter(childName -> childName.compareToIgnoreCase("c") > 0).map(childName -> member.getLastNameOfMember() + " family: " + childName)).forEach(System.out::println); //6
    }

    private static ArrayList<SchulMember> getSchulMembers() {
        SchulMember member1 = new SchulMember("Smith", "Johnny", LocalDate.of(1996, 11, 19), "Anna", "Smith", new String[]{"Johnny", "Rob", "Sara"}, 10);
        SchulMember member2 = new SchulMember("Gold", "Jack", LocalDate.of(1954, 5, 3), "Miriam", "Gold", new String[]{"Aliza", "Rivka"}, 50);
        SchulMember member3 = new SchulMember("Reagan", "Ronald", LocalDate.of(1910, 1, 21), "Rosa", "Reagan", new String[]{"Rachael", "Leah", "Moshe", "Aharon", "Yosef"}, 80);
        SchulMember member4 = new SchulMember("Smith", "Sam", LocalDate.of(1945, 2, 21), "Samantha", "Smith", new String[]{"Mathew"}, 1);
        SchulMember member5 = new SchulMember("Klein", "Moshe", LocalDate.of(1993, 5, 31), "Tzipora", "Klein", new String[]{"Abe", "Lila", "Mat", "Noah", "Joey"}, 15);
        SchulMember member6 = new SchulMember("Fried", "Avraham", LocalDate.of(2000, 12, 15), "Sara", "Fried", new String[]{"Raphael", "Moshe", "Naomi", "Sara"}, 4);
        SchulMember member7 = new SchulMember("Serkez", "Yosef", LocalDate.of(1999, 4, 30), "Kayla", "Serkez", new String[]{"Sammy", "Porter", "Jake"}, 13);
        SchulMember member8 = new SchulMember("Stern", "Ezra", LocalDate.of(2002, 11, 24), "Gitter", "Stern", new String[]{"Morty", "Yogi"}, 2);
        SchulMember member9 = new SchulMember("Cohn", "Huda", LocalDate.of(1974, 7, 10), "Noah", "Cohn", new String[]{"Nancy", "Howard", "Parker", "Bushland", "Nimrod", "Mendel"}, 23);
        SchulMember member10 = new SchulMember("Perez", "Dan", LocalDate.of(1980, 3, 9), "Devorah", "Perez", new String[]{}, 9);
        ArrayList<SchulMember> members = new ArrayList<>(Arrays.asList(member1, member2, member3, member4, member5, member6, member7, member8, member9, member10));
        return members;
    }
}
