package com.epam;

import java.util.*;

public class RightViewReverseOrder {

    static class TreeNode {

        TreeNode left;
        TreeNode right;
        int data;

        TreeNode(int val){
            data = val;
        }
        void addLeft(int val){
            this.left = new TreeNode(val);
        }

        void addRight(int val){
            this.right = new TreeNode(val);
        }
    }

    public static void main (String[] args) {

//	                   10
//	                 /     \
//	                11      12
//	                / \      / \
//	               13  14  15  16
//	                       /
//	                      17
	// O/P: 17->16->12->10

        TreeNode root = new TreeNode(10);
        root.addLeft(11);
        root.addRight(12);

        root.left.addLeft(13);
        root.left.addRight(14);

        root.right.addLeft(15);
        root.right.addRight(16);

        root.right.left.addLeft(17);

        Stack<Integer> rightViewTreeNodes = getBottomUpLinkedListOfRightViewNodes(root);
        while(!rightViewTreeNodes.isEmpty()) {
             System.out.println(rightViewTreeNodes.pop());
        }
    }


    private static Stack<Integer> getBottomUpLinkedListOfRightViewNodes(TreeNode root) {
         Queue<TreeNode> queue = new LinkedList<TreeNode>();
         Stack<Integer> stack = new Stack<Integer>();
         queue.add(root);

         while (!queue.isEmpty()) {
             int nodeCount = queue.size();
             int i = 0;
             while (i++ < nodeCount) {
                    TreeNode polledElement = queue.poll();

                    if (i == nodeCount) {
                        stack.push(polledElement.data);
                    }

                    if (polledElement.left != null) {
                        queue.add(polledElement.left);
                    }
                    if (polledElement.right != null) {
                        queue.add(polledElement.right);
                    }
             }
         }
         return stack;
    }
}
