package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
    private int[] nums;
    private List<List<Integer>> ans;
    private int N;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums=nums;
        this.N=nums.length;
        ans=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        traceBack(0,list);
        return ans;
    }

    private void traceBack(int v, ArrayList<Integer> list){
        ans.add((ArrayList<Integer>)list.clone());
        for (int i=v;i<N;i++){
            list.add(nums[i]);
            traceBack(i+1,list);
            list.remove(list.size()-1);
            while (i+1<N&&nums[i]==nums[i+1]){
                i++;
            }
        }
    }
}
