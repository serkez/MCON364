package Hw4Graphs;

import Hw3HashMap.ArrayMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphTest {
    //Test edges with strings
    @Test
    void legalEdge(){
        Graph2<String> animal = new Graph2<>();
        animal.addVertex("cat");
        animal.addVertex("lion");
        animal.addVertex("wolf");
        animal.addVertex("dog");
        String expected = null;
        String actual = animal.addEdge("cat", "lion");
        assertEquals(expected, actual);
    }
    @Test
    void legalEdge2(){
        Graph2<String> animal = new Graph2<>();
        animal.addVertex("cat");
        animal.addVertex("lion");
        animal.addVertex("wolf");
        animal.addVertex("dog");
        String expected = null;
        String actual = animal.addEdge("cat", "cat");
        assertEquals(expected, actual);
    }
    @Test
    void illegalEdge(){
        Graph2<String> animal = new Graph2<>();
        animal.addVertex("cat");
        animal.addVertex("lion");
        animal.addVertex("wolf");
        animal.addVertex("dog");
        String expected = "cannot add edge because vertex does not exist";
        String actual = animal.addEdge("cat", "tiger");
        assertEquals(expected, actual);
    }

    //Test edges with numbers
    @Test
    //I actually found an interesting error with this test. It wouldnt recognize 3 digit numbers. Still not sure the issue...
    void anotherLegalEdge(){
        Graph2<Integer> animal = new Graph2<>();
        animal.addVertex(43);
        animal.addVertex(756);
        animal.addVertex(34);
        animal.addVertex(34);
        String expected = null;
        String actual = animal.addEdge(43,756);
        assertEquals(expected, actual);
    }
    @Test
    void anotherLegalEdge2(){
        Graph2<Integer> animal = new Graph2<>();
        animal.addVertex(43);
        animal.addVertex(756);
        animal.addVertex(34);
        animal.addVertex(34);
        String expected = null;
        String actual = animal.addEdge(34, 34);
        assertEquals(expected, actual);
    }
    @Test
    void anotherIllegalEdge(){
        Graph2<Integer> animal = new Graph2<>();
        animal.addVertex(43);
        animal.addVertex(756);
        animal.addVertex(34);
        animal.addVertex(34);
        String expected = "cannot add edge because vertex does not exist";
        String actual = animal.addEdge(34, 46);
        assertEquals(expected, actual);
    }
}
