package Hw4Graphs;

//naomi serkez
public class Person {
    private String fName;
    private String lName;
    private int age;

    public Person(String fName, String lName, int age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getFullName() {
        return fName + " " + lName;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return fName;
    }
}
