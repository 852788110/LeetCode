package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<Integer>{
    private List<Integer> list;
    private int first;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        list=new ArrayList<>();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        this.first=0;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (hasNext()){
            return list.get(first);
        }
        return null;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (hasNext()){
            return list.get(first++);
        }
        return -1;
    }

    @Override
    public boolean hasNext() {
        if (first<list.size()){
            return true;
        }
        return false;
    }
}
