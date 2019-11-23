package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    private int[] candidates;
    private int target;
    private List<List<Integer>> ans;
    private int N;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates=candidates;
        this.target=target;
        ans=new ArrayList<>();
        this.N=candidates.length;
        ArrayList<Integer> list=new ArrayList<>();
        Arrays.sort(candidates);
        traceBack(0,0,list);
        return ans;
    }

    private void traceBack(int v, int sum, ArrayList<Integer> list){
        if (sum==target){
            ans.add((List<Integer>)list.clone());
            return;
        }
        if (sum>target){
            return;
        }
        for (int i=v;i<N;i++){
            list.add(candidates[i]);
            sum+=candidates[i];
            traceBack(i+1,sum,list);
            list.remove(list.size()-1);
            sum-=candidates[i];
            /*if (i+1<N&&candidates[i]==candidates[i+1]){
                i++;
            }*/
            int t=i;
            while (t<N&&candidates[t]==candidates[t+1]){
                t++;
            }
            i=t;
        }
    }
}
