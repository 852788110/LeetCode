package com;

import java.util.List;

public class GetPermutation {
    public String getPermutation(int n, int k) {
        /**factorial用于记录阶乘*/
        int[] factorial=new int[n+1];
        boolean[] onMarked=new boolean[n+1];
        /**计算出总数*/
        int sum=1;
        int t=1;
        while (t<=n){
            sum*=t;
            factorial[t]=sum;
            t++;
        }
        onMarked[0]=true;
        StringBuilder res=new StringBuilder();
        traceBack(n,k,factorial,res,onMarked);
        return res.toString();
    }

    private void traceBack(int n, int k, int[] factorial, StringBuilder ans, boolean[] onMarked){
        if (n==0){
            return;
        }
        /**计算排列总数*/
        int sum=factorial[n];
        /**计算每组数都有几个*/
        int each=sum/n;
        /**计算当前k排在第几个*/
        int rank;
        if (k%each==0){
            rank=k/each;
        }else {
            rank=k/each+1;
        }
        if (k%each==0&&k>=each){
            k=each;
        }else {
            k=k%each;
        }

        if (rank==0){
            int i=1;
            while (i<onMarked.length){
                if (onMarked[i]==false){
                    ans.append(i);
                }
                i++;
            }
            return;
        }
        /**寻找当前的目标*/
        int i;
        for (i=1;i<onMarked.length;i++){

            if (onMarked[i]==false){
                rank--;
            }
            if (rank<=0){
                break;
            }
        }
        ans.append(i);
        onMarked[i]=true;
        traceBack(n-1,k,factorial,ans,onMarked);
    }
}
