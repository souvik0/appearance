package com.intel;

import java.util.LinkedList;
import java.util.Queue;

public class RightView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        printRightView(root);
    }

    public static void printRightView(TreeNode root) {
        if (root == null) {
           return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int nodeCount = queue.size();
            int i = 0;
            while (i++ < nodeCount) {
                TreeNode popedNode = queue.poll();
                // Last node from every level
                if (i == nodeCount) {
                    System.out.println(popedNode.data + " ");
                }
                // Level order traversal
                if (popedNode.left != null) {
                    queue.add(popedNode.left);
                }
                if (popedNode.right != null) {
                    queue.add(popedNode.right);
                }
            }
        }
    }
}
