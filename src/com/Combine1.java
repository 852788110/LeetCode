package com;

import java.util.ArrayList;
import java.util.List;

public class Combine1 {
    List<List<Integer>> lists = new ArrayList<>();
    int n,k;

    public List<List<Integer>> combine(int n, int k) {
        this.n=n;
        this.k=k;

        ArrayList<Integer> list = new ArrayList<>();
        trackback(list,1);
        return lists;
    }
    public void trackback(ArrayList<Integer> list,int bg){
        if(list.size()==k){
            lists.add((List<Integer>)list.clone());
            return;
        }
        for(int i=bg;i<=n-(k-list.size())+1;i++){

            // if(list.size()>0)
            // if(i<list.get(list.size()-1)) continue;
            list.add(i);

            trackback(list,i+1);

            list.remove(list.size()-1);
        }
    }
}
