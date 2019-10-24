package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class RandomizedSet {
    private HashSet<Integer> hashSet;
    private List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.hashSet=new HashSet<>();
        this.list=new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!hashSet.contains(val)){
            hashSet.add(val);
            list.add(val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (hashSet.contains(val)){
            hashSet.remove(val);
            int index=list.indexOf(val);
            list.remove(index);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int N=list.size();
        int random=(int)(Math.random()*N);
        return list.get(random);
    }
}
