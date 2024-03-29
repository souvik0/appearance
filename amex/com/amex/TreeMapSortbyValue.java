package com.amex;

import java.util.*;
public class TreeMapSortbyValue {
    public static <K, V extends Comparable<V>> Map<K, V> valueSort(Map<K, V> map) {
        // Static Method with return type Map and
        // extending comparator class which compares values
        // associated with two keys
        Comparator<K> valueComparator = new Comparator<K>() {
                  // return comparison results of values of
                  // two keys
                  public int compare(K k1, K k2) {
                      int comp = map.get(k1).compareTo(map.get(k2));
                      if (comp == 0) {
                          return 1;
                      } else {
                          return (comp > 0) ? comp : -comp; // Return -comp for reverse order
                      }
                  }
        };
        // SortedMap created using the comparator
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);
        sorted.putAll(map);
        return sorted;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        // Put elements to the map
        map.put("Anshu", 2);
        map.put("Rajiv", 4);
        map.put("Chhotu", 3);
        map.put("Golu", 5);
        map.put("Sita", 1);
        // Calling the method valueSort
        Map<String, Integer> sortedMap = valueSort(map);
        // Get a set of the entries on the sorted map
        Set<Map.Entry<String, Integer>> set = sortedMap.entrySet();
        // Get an iterator
        Iterator<Map.Entry<String, Integer>> i = set.iterator();
        // Display elements
        while (i.hasNext()) {
            Map.Entry<String, Integer> mp = (Map.Entry<String, Integer>)i.next();
            System.out.print(mp.getKey() + ": ");
            System.out.println(mp.getValue());
        }
    }
}
