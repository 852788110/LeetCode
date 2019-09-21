package com;

//此问题应该使用荷兰国旗方法解决
public class SortColors {
    public void sortColors(int[] nums) {
        int p0=0,p2=nums.length-1,curr=0;
        while(curr<p2){
            if (nums[curr]==2){
                int temp=nums[curr];
                nums[curr]=nums[p2];
                nums[p2--]=temp;
            }else if (nums[curr]==0){
                int temp=nums[curr];
                nums[curr++]=nums[p0];
                nums[p0++]=temp;
            }else curr++;
        }
    }
}
