package com.himank.leetcode.problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class Problem146 {

    // https://leetcode.com/problems/lru-cache/description/
    public static void main(String[] args) {
        Problem146 lRUCache = new Problem146(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        assert 1 == lRUCache.get(1);
        lRUCache.put(3, 3);
        assert -1 == lRUCache.get(2);
        lRUCache.put(4, 4);
        assert -1 == lRUCache.get(1);
        assert 3 == lRUCache.get(3);
        assert 4 == lRUCache.get(4);
        System.out.println("Success.");
    }

    int capacity;
    LinkedHashMap<Integer, Integer> dic;

    public Problem146(int capacity) {
        this.capacity = capacity;
        dic = new LinkedHashMap<>(5, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return dic.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        dic.put(key, value);
    }
}
