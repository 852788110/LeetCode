package com;

import java.util.Arrays;

/**

* @Description: 这道题使用递归贪心算法，这个方法也行不通

* @Param:

* @return:

* @Author: 刘洁

* @Date:

*/

public class CanPartitionKSubsets1 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int N=nums.length;
        onMarked=new boolean[N];
        int sum=0;
        for (int i=0;i<N;i++){
            sum+=nums[i];
        }
        Arrays.sort(nums);
        int average=sum/k;
        for (int i=N-1;i>=0;i--){
            if (onMarked[i]!=true){
                if (search(nums,i,average)==false){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean[] onMarked;
    private boolean search(int[] nums,int index,int value){
        if (value==0){
            return true;
        }
        if (value<0){
            return false;
        }
        int val=value-nums[index];
        if (val==0){
            onMarked[index]=true;
            return true;
        }
        for (int i=index-1;i>=0;i--){
            if (onMarked[i]==false&&search(nums,i,val)){
                onMarked[index]=true;
                return true;
            }
        }
        return false;
    }
}
