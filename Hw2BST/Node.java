package Hw2BST;

//Naomi Serkez
//2.2024

//This is the node class, for creating and accessing nodes on the tree
public class Node<T> {
    T value;
    private Node<T> leftNode;
    private Node<T> rightNode;

    //constructor
    public Node(T value) {
        this.value = value;
        leftNode = null;
        rightNode = null;
    }

    //setters and getters for node's value, and right and left children
    public void setNode(T value) {
        this.value = value;
    }

    public T getNode() {
        return value;
    }

    public void setRight(Node<T> right) {
        rightNode = right;
    }

    public Node<T> getRight() {
        return rightNode;
    }

    public void setLeft(Node<T> left) {
        leftNode = left;
    }

    public Node<T> getLeft() {
        return leftNode;
    }
}
