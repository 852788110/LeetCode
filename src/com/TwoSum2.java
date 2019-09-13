package com;

import java.util.Arrays;

public class TwoSum2 {
    //折半查找,返回数组下标
    public int rank(int key,int[] nums,int start){
        int lo=start,hi=nums.length-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if (key>nums[mid]) lo=mid+1;
            else if (key<nums[mid]) hi=mid-1;
            else return mid;
        }
        return -1;//查找失败，返回-1
    }
    public int[] twoSum(int[] nums, int target) {
        int[] tempnums=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            tempnums[i]=nums[i];
        }
        Arrays.sort(nums);
        int N=nums.length;
        int[] index=new int[2];
        for (int i=0;i<N;i++){
            int key=target-nums[i];
            int result=rank(key,nums,i+1);
            if (result!=-1){
                index[0]=nums[i];
                index[1]=nums[result];
                index[0]=rank(index[0],tempnums,0);
                if (nums[i]==nums[result]){
                    index[1]=rank(index[1],tempnums,index[0]+1);
                }else {
                    index[1] = rank(index[1], tempnums, 0);
                }
                return index;
            }
        }
        return index;
    }
}
