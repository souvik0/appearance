package com.openText;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String str = "aabc";
        int[] C = new int[] {10, 6, 5, 12};
        System.out.println(solution(str, C));
    }

    public static int solution(String S, int[] C) {
        List<Integer> deletionList = new ArrayList<Integer>();
        int result = 0;

        for (int i = 0; i < S.length() - 1 ; i++) {
             if (S.charAt(i) == S.charAt(i + 1)) {
                 if (C[i] > C[i + 1]) {
                     deletionList.add(C[i + 1]);
                 } else {
                     deletionList.add(C[i]);
                 }
             }
        }

        for (int val: deletionList) {
            result+= val;
        }
        return result;
    }
}
