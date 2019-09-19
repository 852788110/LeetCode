package com;

public class CanJump {
    public boolean canJump(int[] nums) {
        int lastpoint=nums.length-1;
        for (int i=nums.length-1;i>=0;i--){
            if (nums[i]+i>=lastpoint){
                lastpoint=i;
            }
        }
        return lastpoint==0;
    }
}
