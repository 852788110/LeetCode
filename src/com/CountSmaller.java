package com;

import java.util.*;

/**

* @Description: 本题采用树状数组

* @Param:

* @return:

* @Author: 刘洁

* @Date:

*/

public class CountSmaller {
    private int[] treeArray;
    private int[] ranks;
    private Map<Integer,Integer> map;
    /**更新一个结点*/
    private void update(int rank,int val){
        while (rank<treeArray.length){
            treeArray[rank]+=val;
            int lowbit=lowBit(rank);
            rank+=lowbit;
        }
    }

    /**搜索小于或等于这个结点的值*/
    private int query(int rank){
        int sum=0;
        while (rank>0){
            sum+=treeArray[rank];
            int lowbit=lowBit(rank);
            rank-=lowbit;
        }
        return sum;
    }

    private int lowBit(int rank){
        return rank&(-rank);
    }

    public List<Integer> countSmaller(int[] nums) {

        int N=nums.length;
        treeArray=new int[N+1];
        map=new HashMap<>();
        PriorityQueue<Integer> pr=new PriorityQueue<>();
        for (int i=0;i<N;i++){
            pr.add(nums[i]);
        }

        for (int i=1;i<=N;i++){
            map.put(pr.poll(),i);
        }

        int[] rans=new int[N];
        for (int i=N-1;i>=0;i--){
            int rank=map.get(nums[i]);
            update(rank,1);
            int res=query(rank-1);
            rans[i]=res;
        }
        List<Integer> ans=new ArrayList<>();
        for (int i=0;i<N;i++){
            ans.add(rans[i]);
        }
        return ans;
    }
}
