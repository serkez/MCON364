package Hw1Sorting;
//Naomi Serkez
//2.2024
//this class contains the Student object class
public class Student implements Comparable<Student> {
    private String name;
    private int grade;
    //constructor
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }
    public String toString(){
        return name + ": " + grade;
    }
    @Override //compares grade values of Student objects
    public int compareTo(Student o) {
        return Integer.compare(this.getGrade(), o.getGrade());
    }
}
