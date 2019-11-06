package com;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    private List<List<Integer>> ans;
    private int target;
    private int N;
    private int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans=new ArrayList<>();
        this.target=target;
        this.N=candidates.length;
        this.candidates=candidates;
        ArrayList<Integer> list=new ArrayList<>();
        int sum=0;
        traceBack(0,sum,list);
        return ans;
    }

    private void traceBack(int v,int sum,ArrayList<Integer> list){
        if (sum==target){
            ans.add((List<Integer>)list.clone());
            return;
        }
        if (sum>target){
            return;
        }
        for (int i=0;i<N;i++){
            list.add(candidates[i]);
            sum+=candidates[i];
            traceBack(i,sum,list);
            list.remove(list.size()-1);
            sum-=candidates[i];
        }
    }
}
