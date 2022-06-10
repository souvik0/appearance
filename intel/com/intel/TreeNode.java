package com.intel;

// Any tree like data structure can be represented by it's representing node class
/* Here TreeNode class can represent BinaryTree, BinarySerachTree, AVL Tree also doubly linked list uses same
   appearance */

public class TreeNode {

    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}