package com.openText;

import java.util.Arrays;

public class PrintEvenNumbers {

    public static void main(String[] args) {
        int[] arr = new int[] {-5, 3, 4, 7, -13, -12};
        printEvenNumbers(arr);
    }

    public static void printEvenNumbers(int[] arr) {
        Arrays.stream(arr).filter(i -> i % 2 == 0).forEach(System.out::println);
    }
}
