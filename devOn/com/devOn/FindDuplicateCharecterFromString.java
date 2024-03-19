package com.devOn;

import java.util.*;

public class FindDuplicateCharecterFromString {

    public static void main(String[] args) {
        String str = "Welcome to my world";
        System.out.println((findDuplicates(str)).toString());
    }

    public static List<Character> findDuplicates(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
        List<Character> duplicateList = new ArrayList<Character>();

        for (Character ch: str.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        for (Character ch : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(ch);
            if (frequency > 1) {
                duplicateList.add(ch);
            }
        }

        return duplicateList;
    }
}
