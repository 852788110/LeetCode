package com;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] res=new int[cost.length+1];
        res[0]=cost[0];
        res[1]=cost[1];
        return subResult(cost,res,cost.length);
    }

    private int subResult(int[] cost,int[] res,int n){
        if (n==0) return cost[0];
        if (n==1) return cost[1];
        if (res[n-1]<=0)    res[n-1]=subResult(cost,res,n-1);
        if (res[n-2]<=0)    res[n-2]=subResult(cost,res,n-2);
        if (n<cost.length) res[n]=Math.min(res[n-1],res[n-2])+cost[n];
        else res[n]=Math.min(res[n-1],res[n-2]);
        return res[n];
    }
}
