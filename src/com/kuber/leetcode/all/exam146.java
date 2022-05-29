package com.kuber.leetcode.all;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*146. LRU 缓存机制 Least Recently Used*/
public class exam146 extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public exam146(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

}

