package com;

public class NumArray {
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums=nums;
    }

    public void update(int i, int val) {
        this.nums[i]=val;
    }

    public int sumRange(int i, int j) {
        int sum=0;
        for (;i<=j;i++){
            sum+=nums[i];
        }
        return sum;
    }
}
