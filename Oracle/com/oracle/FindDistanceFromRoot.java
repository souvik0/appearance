package com.oracle;

import com.intel.TreeNode;

public class FindDistanceFromRoot {

    public static void main(String[] args) {
        
    }

    private static int getDistanceFromRoot(TreeNode root, int nodeData, int level) {
        if (root == null) {
            return -1;
        }

        if (root.data == nodeData) {
            return level;
        } else {
            level++;
        }

        int left = getDistanceFromRoot(root.left, nodeData, level);

        if (left == -1) {
            return getDistanceFromRoot(root.right, nodeData, level);
        }

        return left;
    }

    private static TreeNode lowestCommonParent(TreeNode root, TreeNode a, TreeNode b) {
        if (a == null || b == null) {
           return null;
        }

        if ((root.data == a.data) || (root.data == b.data)) {
            return root;
        }

        TreeNode left = lowestCommonParent(root.left, a, b);
        TreeNode right = lowestCommonParent(root.right, a, b);

        if (left != null && right != null) {
            return root;
        } else if (left == null) {
            return right;
        } else {
            return left;
        }
    }
}
