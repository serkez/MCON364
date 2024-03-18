package Hw4Graphs;

import java.util.LinkedList;
import java.util.Queue;

import static java.util.Arrays.fill;

//naomi serkez
public class Graph2<T> {
    private T[] vertices;
    private boolean[] marks;
    private int[][] edges;
    private int DEF_VERTICES = 50;
    private int vertexCounter = 0;
    //default constructor
    public Graph2() {
        vertices = (T[]) new Object[DEF_VERTICES];
        edges = new int[DEF_VERTICES][DEF_VERTICES];
        marks = new boolean[DEF_VERTICES];
    }
    //overloaded with size of graph(vertices)
    public Graph2(int maxVertices) {
        vertices = (T[]) new Object[maxVertices];
        edges = new int[maxVertices][maxVertices];
        marks = new boolean[maxVertices];
    }
//add vertex
    public void addVertex(T vertex) {
        vertices[vertexCounter] = vertex;
        for (int index = 0; index < vertexCounter; index++) {
            edges[vertexCounter][index] = 0;
            edges[index][vertexCounter] = 0;
        }
        vertexCounter++;
    }
//add edge
    public String addEdge(T vertex1, T vertex2) {
        if (indexOf(vertex1) == -1 || indexOf(vertex2) == -1)
            return "cannot add edge because vertex does not exist";
        else {
            edges[indexOf(vertex1)][indexOf(vertex2)] = 1;
            edges[indexOf(vertex2)][indexOf(vertex1)] = 1;
            return null;
        }
    }
//retuns index of vertex in vertices array
    private int indexOf(T vertex) {
        for (int i = 0; i < vertexCounter; i++) {
            if (vertices[i] == vertex)
                return i;
        }
        return -1;
    }
///checks for path using BFS
    public boolean isPath(T startVertex, T endVertex) {
        boolean found = false;
        fill(marks, false);
        T currVertex;
        Queue<T> list = new LinkedList<>();
        marks[indexOf(startVertex)] = true; //index is from vertices array
        list.add(startVertex);
        while (!list.isEmpty() && !found) {
            currVertex = list.poll();
            if (currVertex == endVertex) {
                found = true;
            } else {
                //this is the line that chatGPT fixed for me (it also tried fixing other stuff that was unnesesary
                for (int i = 0; i < vertexCounter; i++) { //ORIGINALLY: for(int i : edges[indexOf(currVertex)]){
                    if (edges[indexOf(currVertex)][i] == 1 && !marks[i]) {
                        marks[i] = true;
                        list.add(vertices[i]);
                    }
                }
            }
        }
        return found;
    }
//prints graph
    public void printGraph(String[] title) {
        System.out.println("                  The Friend Matrix");
        System.out.println();
        System.out.print("       ");
        for (String t : title) {
            System.out.print(t + " ");
        }
        System.out.println();
        for (int i = 0; i < vertexCounter; i++) {
            System.out.print(title[i] + "   ");
            for (int j = 0; j < vertexCounter; j++) {
                System.out.print(edges[i][j] + "     ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
