package com;

public class CountBits {
    public int[] countBits(int num) {
        int[] res=new int[num+1];
        res[0]=0;
        for (int i=1;i<=num;i++){
            int t=i;
            if (t%2!=0) res[i]++;
            t=t/2;
            res[i]+=res[t];
        }
        return res;
    }
}
