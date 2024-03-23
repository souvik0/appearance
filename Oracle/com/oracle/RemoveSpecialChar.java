package com.oracle;

import java.util.*;

public class RemoveSpecialChar {

    public static void main(String[] args) {
        String str = "AB#GF#HI###JK#LK";
        Stack<Character> stack = replaceSpecialChar(str);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
              sb.append(stack.pop());
        }

        System.out.print(reverse(sb.toString()));
    }

    public static String reverse(String word) {
        if ((word == null) || (word.length() <= 1)) {
            return word;
        } else {
            return reverse(word.substring(1)) +
                   word.charAt(0);
        }
    }

    public static Stack<Character> replaceSpecialChar(String input) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isLetter(ch)) {
                stack.push(ch);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        return stack;
    }
}
