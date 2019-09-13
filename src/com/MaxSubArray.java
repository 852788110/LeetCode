package com;

//该题采用动态规划算法
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int ans=nums[0],sum=0,N=nums.length;
        for (int num:nums) {
            if (sum>0){
                sum+=num;
            }else {
                sum=num;
            }
            ans=Math.max(sum,ans);
        }
        return ans;
    }
}
