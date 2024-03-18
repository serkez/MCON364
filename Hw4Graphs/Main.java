package Hw4Graphs;

//naomi serkez
public class Main {
    public static void main (String[] args){
        Graph2<Person> people = new Graph2<>(9);
        //create people to populate graph
        Person p1 = new Person("Sammy", "Newswald", 23);
        Person p2 = new Person("Rosey", "Older", 60);
        Person p3 = new Person("Naomi", "Serkez", 45);
        Person p4 = new Person("Hudia", "Cohen", 28);
        Person p5 = new Person("Sofia", "Peretz", 18);
        Person p6 = new Person("Anita", "Rock", 5);
        Person p7 = new Person("Goldy", "Pepper", 75);
        Person p8 = new Person("Johny", "Smith", 12);
        Person p9 = new Person("Jerem", "Doe", 64);
        //populate graph
        people.addVertex(p1);
        people.addVertex(p2);
        people.addVertex(p3);
        people.addVertex(p4);
        people.addVertex(p5);
        people.addVertex(p6);
        people.addVertex(p7);
        people.addVertex(p8);
        people.addVertex(p9);
        //add relationships
        people.addEdge(p1, p2);
        people.addEdge(p1, p4);
        people.addEdge(p1, p6);
        people.addEdge(p3, p2);
        people.addEdge(p5, p4);
        people.addEdge(p2, p6);
        people.addEdge(p7, p3);
        people.addEdge(p8, p5);
        people.addEdge(p9, p6);
        people.addEdge(p8, p3);
        people.addEdge(p6, p5);
        people.addEdge(p7, p9);
        people.addEdge(p7, p2);
        people.addEdge(p9, p4);
        people.addEdge(p8, p7);
        //print graph and check for paths
        people.printGraph(new String[]{p1.getfName(), p2.getfName(), p3.getfName(), p4.getfName(), p5.getfName(), p6.getfName(), p7.getfName(), p8.getfName(), p9.getfName()});
        System.out.println(p9.getFullName() + " can find a way to become friends with " + p4.getFullName() + "? " + people.isPath(p9, p4));
        System.out.println(p1.getFullName() + " can find a way to become friends with " + p5.getFullName() + "? " + people.isPath(p1, p5));
        System.out.println(p3.getFullName() + " can find a way to become friends with " + p7.getFullName() + "? " + people.isPath(p3, p7));
        System.out.println(p8.getFullName() + " can find a way to become friends with " + p1.getFullName() + "? " + people.isPath(p8, p1));
    }
}
