package com;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**

* @Description: 采用树状数组,解法错误

* @Param:

* @return:

* @Author: 刘洁

* @Date:

*/

public class CountRangeSum {
    private Map<Integer,Integer> map;
    private int[] arrayTree;
    private int ans=0;
    public int countRangeSum(int[] nums, int lower, int upper) {
        int N=nums.length;
        map=new HashMap<>(2*N+1);
        arrayTree=new int[2*N+1];
        for (int i=0;i<N;i++){
            add(N+1+i,nums[i]);
            map.put(i,N+1+i);
        }
        for (int i=0;i<N;i++){
            query(map.get(i),lower,upper);
            delete(map.get(i),nums[i]);
            map.remove(i);
        }
        return ans;
    }

    private void add(int rank,int val){
        while (rank>0){
            arrayTree[rank]+=val;
            rank=rank/2;
        }
    }

    private void delete(int rank,int val){
        while(rank>0){
            arrayTree[rank]-=val;
            rank=rank/2;
        }
    }

    private void query(int rank,int lower,int upper){
        while (rank>0){
            int temp=arrayTree[rank];
            if (temp>=lower&&temp<=upper){
                ans++;
            }
            rank=rank/2;
        }
    }
}
