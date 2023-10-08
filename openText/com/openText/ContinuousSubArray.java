package com.openText;

import java.util.*;

public class ContinuousSubArray {

    public static void main(String[] args) {
        int[] arr = new int[] {-5, 3, 4, 7, -13, -12};
        int givenSum = maximumSubArraySum(arr);
        findContSubArray(arr, givenSum);
    }

    // To locate the startIndex & endIndex of the given sum
    public static void findContSubArray(int[] arr, int givenSum) {
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        int left = 0;
        int currentSum = 0;
        int right = -1;

        for (int i = 0; i < arr.length; i++) {
             currentSum = currentSum + arr[i];

             if (currentSum == givenSum) {
                 right = i;
             }

             if (hmap.containsKey(currentSum - givenSum)) {
                 left = hmap.get(currentSum - givenSum) + 1;
                 right = i;
             }
             hmap.put(currentSum, i);
        }

        if (right != -1) {
            System.out.println("Continuous sum exist in the range: " + left + " to " + right);
        } else {
            System.out.println("Sum doen't exist");
        }
    }

    public static int maximumSubArraySum(int[] arr) {
        int currentSum = arr[0];
        int max_so_far = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = currentSum + arr[i];
            currentSum = Math.max(currentSum, arr[i]);
            max_so_far = Math.max(currentSum, max_so_far);
        }

        System.out.println("Maximum sum:" + max_so_far);
        return max_so_far;
    }
}
