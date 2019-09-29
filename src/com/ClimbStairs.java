package com;

public class ClimbStairs {
    public int climbStairs(int n) {
        if (n==1) return 1;
        if (n==2) return 2;
        return climbStairs(n-1)+climbStairs(n-2);
    }

    public long climbStairs1(int n){
        long[] res=new long[n+1];
        return subCS(n,res);
    }

    private long subCS(int n,long[] res){
        if (n==1) return 1;
        if (n==2) return 2;
        int temp=0;
        if (res[n-1]>0) temp+=res[n-1];
        else{
            res[n-1]=subCS(n-1,res);
            temp+=res[n-1];
        }

        if (res[n-2]>0) temp+=res[n-2];
        else{
            res[n-2]=subCS(n-2,res);
            temp+=res[n-2];
        }
        return temp;
    }
}
