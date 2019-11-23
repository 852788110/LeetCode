package com;

import java.util.ArrayList;
import java.util.List;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int N=nums.length;
        boolean[] onMarked=new boolean[N+1];
        ArrayList<Integer> list=new ArrayList<>();
        traceBack(N,1,nums,onMarked,ans,list);
        return ans;
    }

    private void traceBack(int N,int d,int[] nums,boolean[] onMarked,List<List<Integer>> ans,ArrayList<Integer> list){
        if (d>N){
            ans.add((ArrayList)list.clone());
            return;
        }
        for (int i=0;i<N;i++){
            if (onMarked[i]==false){
                onMarked[i]=true;
                list.add(nums[i]);
                traceBack(N,d+1,nums,onMarked,ans,list);
                onMarked[i]=false;
                list.remove(list.size()-1);
                while (i+1<N&&nums[i]==nums[i+1]){
                    i++;
                }
            }
        }
    }
}
