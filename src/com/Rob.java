package com;

public class Rob {
    public int rob(int[] nums) {
        int premax=0,curmax=0;
        for (int i:nums){
            int temp=curmax;
            curmax=Math.max(premax+i,curmax);
            premax=temp;
        }
        return curmax;
    }
}
