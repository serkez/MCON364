package LambdaLab;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Write a Predicate<Student> called isAdult that tests if a student is an adult (age >= 18).
        Predicate<Student> isAdult = s -> s.getAge() >= 18;
        //Write a Consumer<Student> called printName that prints a student's name.
        Consumer<Student> printName = s -> System.out.println(s.getName());
        //Write a Supplier<Student>  called createDefaultStudent that returns
        // a new student with a default name, age, and GPA.
        Supplier<Student> createDefaultStudent = () -> new Student("Naomi Serkez", 21, 4.0);
        //Write a Function<Student, String> called getName that returns a student's name.
        Function<Student, String> getName = Student::getName;
        //Write a BiFunction<Student, Double, Student> called updateGPA that updates a student's GPA and returns the student.
        BiFunction<Student, Double, Student> updateGPA = (s, d) -> new Student(s.getName(), s.getAge(), d);
        //Write a BiPredicate<Student, Double> called hasHighGpa that tests if a student's GPA is above a certain threshold.
        BiPredicate<Student, Double> hasHighGpa = (s, d) -> s.getGpa() > d;
        //Write a BiConsumer<Student, String> called updateName that updates a student's name.
        BiConsumer<Student, String> updateName = Student::setName;
        // Create a list of students. Use the stream method to create a stream,
        // then use filter to find all adult students (isAdult),
        // map to get their names, and collect to put the names into a new list.
        Student s1 = new Student("Nancy Name", 19, 3.4);
        Student s2 = new Student("John Smith", 17, 4.0);
        Student s3 = new Student("Joe Jack", 20, 2.4);
        Student s4 = new Student("Ron Reagan", 17, 3.8);
        Student s5 = new Student("Tammy Gold", 18, 3.0);
        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        List<String> studentNamesOver18 = students.stream().filter(isAdult).map(Student::getName).toList();
        System.out.print(studentNamesOver18);
        /*
        Question 9
        Use the randomStudentSupplier to generate a list of 100 students.
        Filter out students who are adults and have a GPA above 3.0 using isAdult and hasHighGpa.
        Use the appendToName BiConsumer to append " - Scholar" to the name of each of these students.
        Collect the names of these students into a list.
        */

    }
}
