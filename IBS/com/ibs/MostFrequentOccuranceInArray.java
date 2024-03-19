package com.ibs;

import java.util.*;

public class MostFrequentOccuranceInArray {

    public static void main(String[] args) {
        String[] countryArr = new String[] {"India", "USA", "Russia", "India", "China",
                                            "Australia", "India","China", "Australia"};
        System.out.println(maxFrequencyString(countryArr));
    }

    public static String maxFrequencyString(String[] countryArr) {
         if (countryArr == null || countryArr.length == 0) {
             return null; // Handle empty or null array
         }

         Map<String, Integer> frequencyMap = new HashMap<>();
         int maxFrequency = 0;
         String maxFrequencyString = null;

         for (String str : countryArr) {
             frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
         }

         for (String country: frequencyMap.keySet()) {
             int frequency = frequencyMap.get(country);
             if (frequency> maxFrequency) {
                 maxFrequency = frequency;
                 maxFrequencyString = country;
             }
         }

         return maxFrequencyString;
    }
}
