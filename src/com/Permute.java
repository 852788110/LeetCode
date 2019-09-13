package com;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    //参数：
    // result：返回的最终结果
    private void backtrace(List<List<Integer>> result,List<Integer> subresult,int[] nums,int max){
        if (subresult.size()>=max){
            result.add(subresult);
            return;
        }
        int N=nums.length;
        for (int i=0;i<N;i++){
            if (!subresult.contains(nums[i])){
                List<Integer> temp=new ArrayList<Integer>();
                for (Integer s:subresult) {
                    temp.add(s);
                }
                temp.add(nums[i]);
                backtrace(result,temp,nums,max);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> subresult=new ArrayList<Integer>();
        int max=nums.length;
        backtrace(result,subresult,nums,max);
        return result;
    }
}
