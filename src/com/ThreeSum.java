package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.binarySearch;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results=new ArrayList<>();
        Arrays.sort(nums);
        int N=nums.length;
        for (int i=0;i<N;i++){
            for (int j=i+1;j<N;j++){
                int two_sum=nums[i]+nums[j];
                if (-two_sum<nums[j]) break;
                int index=Arrays.binarySearch(nums,j+1,N,-two_sum);
                if (index>0){
                    ArrayList<Integer> result=new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(nums[index]);
                    //if (!results.contains(result))
                        results.add(result);
                }

            }
        }
        return results;
    }
}
