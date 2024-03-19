package com.epam;

// get operation: O(1)
// write operation : O(1)

import java.util.*;

public class SimpleCache<K, V> {

    private Map<K, EntryNode<K, V>> tempMap;
    private EntryNode<K, V> start, end;
    private int DEFAULT_CACHE_SIZE = 3;

    public static void main(String[] args) {
        SimpleCache<String, String> simpleCache = new SimpleCache<String, String>();
        simpleCache.write("K1", "V1");
        simpleCache.write("K2", "V2");
        simpleCache.write("K3", "V3");
        simpleCache.write("K4", "V4");

        System.out.println(simpleCache.get("K2"));
        System.out.println(simpleCache.get("K3"));
        System.out.println(simpleCache.get("K1"));
        System.out.println(simpleCache.get("K2"));
    }

    @SuppressWarnings("unchecked")
    public SimpleCache() {
        tempMap = (Map<K, EntryNode<K, V>>) new HashMap<K, V>();
        start = end = null;
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        EntryNode<K, V> entry = null;
        if (tempMap.containsKey(key)) {
            entry = tempMap.get(key);
            removeNode(entry);
            addAtFirst(entry);
        }
        return entry != null ? entry.value: (V) "null";
    }

    public void write(K key, V value) {
        if (tempMap.containsKey(key)) {
            EntryNode<K, V> entry = tempMap.get(key);
            removeNode(entry);
            entry.value = value;
            addAtFirst(entry);
        } else {
            EntryNode<K, V> newEntry = new EntryNode<K, V>();
            newEntry.left = null;
            newEntry.right = null;
            newEntry.key = key;
            newEntry.value = value;

            if (tempMap.size() >= DEFAULT_CACHE_SIZE) {
                tempMap.remove(end.key);
                removeNode(end);
                addAtFirst(newEntry);
            } else {
                addAtFirst(newEntry);
            }

            tempMap.put(key, newEntry);
        }
    }

    public void addAtFirst(EntryNode<K, V> newEntryNode) {
        if (start != null) {
            newEntryNode.right = start;
            start.left = newEntryNode;
            start = newEntryNode;
        } else {
            start = end = newEntryNode;
        }
    }

    @SuppressWarnings("unchecked")
    public void removeNode (EntryNode<K, V> node) {
        if (node.left != null) {
            node.left.right = node.right;
        } else {
            start = start.right;
        }

        if (node.right != null) {
            node.right.left = node.left;
        } else {
            end = end.left;
        }
    }
}
