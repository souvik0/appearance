package com.oracle;

import java.util.*;

import com.intel.TreeNode;

public class FindHighestValueFromEachLevel {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(10);

        List<Integer> maxValueList = printHighestValueFromEachLevel(root);
        System.out.println(maxValueList.toString());
    }

    public static List<Integer> printHighestValueFromEachLevel(TreeNode root) {
        int maxValueFromEachLevel = -1;
        List<Integer> maxValueList = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int currentLevel = 0; // Starting Level
        queue.add(root);

        while (!queue.isEmpty()) {
            int nodeCountFromEachLevel = queue.size();
            // This while traverse for each Level
            while (nodeCountFromEachLevel > 0) {
                TreeNode polledNode = queue.poll();
                maxValueFromEachLevel = Math.max(maxValueFromEachLevel, polledNode.data);

                if (polledNode.left != null) {
                    queue.add(polledNode.left);
                }
                if (polledNode.right != null) {
                    queue.add(polledNode.right);
                }
                nodeCountFromEachLevel--;
            }
            maxValueList.add(maxValueFromEachLevel);
            currentLevel++;
        }

        return maxValueList;
    }
}
