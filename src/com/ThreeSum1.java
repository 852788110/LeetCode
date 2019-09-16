package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results=new ArrayList<>();
        Arrays.sort(nums);
        int N=nums.length;
        if(nums == null || N < 3) return results;
        for (int i=0;i<N;i++){
            if (nums[i]>0) break;
            if (i>0&&nums[i]==nums[i-1]) continue;
            int le=i+1,hl=N-1;
            while(le<hl){
                int sum=nums[i]+nums[le]+nums[hl];
                if (sum>0)  hl--;
                else if (sum==0){
                    List<Integer> result=new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[le]);
                    result.add(nums[hl]);
                    while (le<hl && nums[le] == nums[le+1]) le++; // 去重
                    while (le<hl && nums[hl] == nums[hl-1]) hl--;
                    le++;
                    hl--;
                    results.add(result);
                }else {
                    le++;
                }
            }
        }
        return results;
    }
}
