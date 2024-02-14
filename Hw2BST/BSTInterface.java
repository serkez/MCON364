package Hw2BST;

import java.util.*;
//Naomi Serkez
//2.2024
public interface BSTInterface<T> extends Collection<T>, Iterable<T> {
    enum Traversal{Inorder, Preorder, Postorder}

    T min();
    T max();
}

