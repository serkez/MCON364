package Hw2BST;

import java.util.*;

//Naomi Serkez
//2.2024
public class BinarySearchTree<T> {
    protected Node root;
    protected Comparator<T> comp;
    protected boolean found;

    public BinarySearchTree() {
        root = null;
        comp = new Comparator<>() { //sets compare method for natural ordering
            public int compare(T element1, T element2) {
                return ((Comparable<T>) element1).compareTo(element2);
            }
        };
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public T min() { //gets min value by traversing as left as possible
        if (isEmpty()) {
            return null;
        } else {
            Node<T> node = root;
            while (node.getLeft() != null) {
                node = node.getLeft();
            }
            return node.getNode();
        }
    }

    public T max() { //gets max value by traversing as right as possible
        if (isEmpty()) {
            return null;
        } else {
            Node<T> node = root;
            while (node.getRight() != null) {
                node = node.getRight();
            }
            return node.getNode();
        }
    }

    public int size() {
        return recSize(root);
    }

    private int recSize(Node<T> node) { //adds up all the nodes
        if (node == null) {
            return 0;
        } else {
            return 1 + recSize(node.getLeft()) + recSize(node.getRight());
        }
    }

    public boolean contains(T value) {
        return recContains(value, root);
    }

    //checks for value
    private boolean recContains(T value, Node<T> node) {
        if (node == null) { // does not contain
            System.out.println(value + " not found");
            return false;
        } else if (comp.compare(value, node.getNode()) < 0) { //calls method moving down one branch to the left
            System.out.println(" " + value + " is less than " + node.getNode() + " ");
            return recContains(value, node.getLeft());
        } else if (comp.compare(value, node.getNode()) > 0) { //calls method moving down one branch to the right
            System.out.println(" " + value + " is more than " + node.getNode() + " ");
            return recContains(value, node.getRight());
        } else {
            System.out.println(value + " found");
            return true;
        }
    }

    public T get(T value) {
        return (T) recGet(value, root);
    }

    private T recGet(T value, Node<T> node) {
        if (node == null) {
            return null;
        } else if (comp.compare(value, node.getNode()) < 0) {
            return recGet(value, node.getLeft());
        } else {
            if (comp.compare(value, node.getNode()) > 0) {
                return recGet(value, node.getRight());
            } else {
                return node.getNode();
            }
        }
    }

    public void traverseBFS() {
        recTraverseBFS(root);
    }

    private ArrayList<T> recTraverseBFS(Node<T> node) {
        ArrayList<T> ret = new ArrayList<>();
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        if (node != null) {
            queue.add(node);
            while (!queue.isEmpty()) {
                node = queue.remove();
                ret.add(node.getNode());
                if (node.getLeft() != null) queue.add(node.getLeft());
                if (node.getRight() != null) queue.add(node.getRight());
            }
        }
        return ret; //used for printing tree (toString)
    }

    //DFS
    public Iterator<T> getIterator(BSTInterface.Traversal orderType) {
        final Queue<T> infoQ = new LinkedList<>();
        if (orderType == BSTInterface.Traversal.Preorder) preOrder(root, infoQ);
        else if (orderType == BSTInterface.Traversal.Inorder) inOrder(root, infoQ);
        else postOrder(root, infoQ);
        return new Iterator<>() {
            public boolean hasNext() {
                return !infoQ.isEmpty();
            }

            public T next() {
                if (!hasNext())
                    throw new IndexOutOfBoundsException("illegal invocation of next " + " in BinarySearchTree iterator.\n");
                return infoQ.remove();
            }

            public void remove() {
                throw new UnsupportedOperationException("Unsupported remove attempted " + "on BinarySearchTree iterator.\n");
            }
        };

    }

    private void inOrder(Node<T> node, Queue<T> q) {
        if (node != null) {
            inOrder(node.getLeft(), q);
            q.add(node.getNode());
            inOrder(node.getRight(), q);
        }
    }

    private void preOrder(Node<T> node, Queue<T> q) {
        if (node != null) {
            q.add(node.getNode());
            preOrder(node.getLeft(), q);
            preOrder(node.getRight(), q);
        }
    }

    private void postOrder(Node<T> node, Queue<T> q) {
        if (node != null) {
            postOrder(node.getLeft(), q);
            postOrder(node.getRight(), q);
            q.add(node.getNode());
        }
    }

    public boolean add(T value) {
        root = recAdd(value, root);
        System.out.println("Successfully added " + value);
        return true;
    }

    private Node<T> recAdd(T value, Node<T> node) {
        if (node == null) node = new Node<>(value);
        else if (comp.compare(value, node.getNode()) <= 0) node.setLeft(recAdd(value, node.getLeft()));
        else //comp.compare(value, node.getNode()) > 0
            node.setRight(recAdd(value, node.getRight()));
        return node;
    }

    public boolean remove(T value) {
        root = recRemove(value, root);
        if (!found)
            System.out.println(value + " is not in the tree ");
        else
            System.out.println("Successfully removed " + value);
        return found;
    }

    private Node<T> recRemove(T value, Node<T> node) {
        if (node == null) found = false;
        else if (comp.compare(value, node.getNode()) < 0) node.setLeft(recRemove(value, node.getLeft()));
        else if (comp.compare(value, node.getNode()) > 0) node.setRight(recRemove(value, node.getRight()));
        else node = removeNode(node);
        return node;
    }

    private Node<T> removeNode(Node<T> node) {
        T data;
        if (node.getLeft() == null && node.getRight() == null) {
            System.out.println(node.getNode() + " is a leaf. Removing...");
            return null;
        } else if (node.getLeft() == null) {
            System.out.println(node.getNode() + " had a Light child. Removing node and replacing with " + node.getRight().getNode());
            return node.getRight();
        } else if (node.getRight() == null) {
            System.out.println(node.getNode() + " had a Left child. Removing node and replacing with " + node.getLeft().getNode());
            return node.getLeft();
        } else {
            System.out.println(node.getNode() + " had 2 children. getting predecessor...");
            data = getPredecessor(node.getLeft());
            node.setNode(data);
            System.out.println(" Removing node and replacing with " + node.getNode());
            node.setLeft(recRemove(data, node.getLeft()));
            return node;
        }
    }

    private T getPredecessor(Node<T> subtree) {
        System.out.println("Looking for predecessor... ");
        Node<T> temp = subtree;
        while (temp.getRight() != null) temp = temp.getRight();
        System.out.println("Predecessor = " + temp.getNode());
        return temp.getNode();
    }

    //prints tree in BFS order (by levels)
    public String toString() {
        ArrayList<T> tree = recTraverseBFS(root);
        StringBuilder str = new StringBuilder();
        for (T node : tree) {
            str.append(node);
            str.append(", ");
        }
        return str.toString();
    }

}
