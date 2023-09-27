package com.openText;

// BALLOON
import java.util.*;

public class BalloonDeletion {

    public static void main(String[] args) {
    }

    public int solution(String S) {
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        int strLength = S.length();
        int totalCount = 0;

        for (int i = 0; i < S.length(); i++) {
            if (charMap.containsKey(S.charAt(i))) {
                charMap.put(S.charAt(i), charMap.get(S.charAt(i)) + 1);
            } else {
                charMap.put(S.charAt(i), 1);
            }
        }

        if (charMap.containsKey('B') || charMap.containsKey('A') || charMap.containsKey('L') ||
            charMap.containsKey('O') || charMap.containsKey('N')) {
            int bCount = charMap.get('B');
            int aCount = charMap.get('A');
            int lCount = charMap.get('L');
            int oCount = charMap.get('O');
            int nCount = charMap.get('N');
            totalCount = bCount + aCount + lCount + oCount + nCount;
        }

        if (strLength != totalCount) {
            for (Map.Entry<Character, Integer> entry: charMap.entrySet()) {
                 if (entry.getKey() != 'B' || 
                     entry.getKey() != 'A' ||
                     entry.getKey() != 'L' ||
                     entry.getKey() != 'O' ||
                     entry.getKey() != 'N' ) {
                         charMap.remove(entry.getKey());
                 }
            }
        }
    }
}
