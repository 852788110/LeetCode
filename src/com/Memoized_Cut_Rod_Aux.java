package com;

public class Memoized_Cut_Rod_Aux {
    //top-down with memoization
    public int cut_rod_1(int[] prices,int n){
        int lens=prices.length;
        int[] revenue=new int[lens];
        for (int i=1;i<lens;i++){
            revenue[i]=Integer.MIN_VALUE;
        }
        return memoized_cut_ord(prices,n,revenue);
    }

    private int memoized_cut_ord(int[] prices,int n,int[] revenue){
        if (revenue[n]>=0) return revenue[n];
        int q=0;
        if (n==0)   q=0;
        else {
            q=Integer.MIN_VALUE;
            for (int i=1;i<=n;i++){
                q=Math.max(q,prices[i]+memoized_cut_ord(prices,n-i,revenue));
            }
        }
        revenue[n]=q;
        return q;
    }

    //recursive top-down implementation
    public int cut_rod(int[] prices,int n){
        if (n==0) return 0;
        int q=Integer.MIN_VALUE;
        for (int i=1;i<=n;i++){
            q=Math.max(q,prices[i]+cut_rod(prices,n-i));
        }
        return q;
    }
}
