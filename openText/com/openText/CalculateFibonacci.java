package com.openText;

public class CalculateFibonacci {

    public static void main(String[] args) {
    }

    public int fibo(int num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return fibo(num - 1) + fibo(num - 2);
        }
    }
}
