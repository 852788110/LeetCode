package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subsets {
    private List<List<Integer>> ans;
    private int[] nums;
    private int N;
    public List<List<Integer>> subsets(int[] nums) {
        this.ans=new ArrayList<>();
        this.nums=nums;
        N=nums.length;
        subset(0);
        List<Integer> zero=new ArrayList<>();
        ans.add(zero);
        return ans;
    }

    private void subset(int index){
        if (index>=N-1){
            List<Integer> res=new ArrayList<>();
            res.add(nums[index]);
            ans.add(res);
            return;
        }
        subset(index+1);
        int size=ans.size();
        for (int i=0;i<size;i++){
            List<Integer> res=new ArrayList<>();
            res.add(nums[index]);
            for (int t:ans.get(i)){
                res.add(t);
            }
            ans.add(res);
        }
        List<Integer> res=new ArrayList<>();
        res.add(nums[index]);
        ans.add(res);
    }
}
