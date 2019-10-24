package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    private List<Integer> ans;
    private int first;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.ans=new ArrayList<>();
        this.first=0;
        for (NestedInteger n:nestedList){
            if (n.isInteger()){
                ans.add(n.getInteger());
            }else {
                for (NestedInteger nest:n.getList()){
                    init(nest);
                }
            }
        }
    }

    private void init(NestedInteger nest){
        if (nest.isInteger()){
            ans.add(nest.getInteger());
        }else {
            for (NestedInteger n:nest.getList()){
                init(n);
            }
        }
    }

    @Override
    public Integer next() {
        if (hasNext()){
            return ans.get(first++);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if (first>=ans.size()){
            return false;
        }
        return true;
    }
}