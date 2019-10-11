package com;

public class FindMaximumXOR {
    public int findMaximumXOR(int[] nums) {
        int max=Integer.MIN_VALUE,lens=nums.length;
        for (int i=0;i<lens;i++){
            for (int j=i+1;j<lens;j++){
                int temp=nums[i]^nums[j];
                if (temp>max){
                    max=temp;
                }
            }
        }
        return max;
    }
}
