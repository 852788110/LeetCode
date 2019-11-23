package com;

public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        return dfs(n);
    }

    private int dfs(int n){
        if (n==0){
            return 0;
        }
        if (n==1){
            return 10;
        }
        if (n==2){
            return 91;
        }
        if (n==3){
            return 739;
        }

        int i=9,t=n;
        int res=9;
        t--;
        while (t>0){
            res*=i;
            i--;
            t--;
        }
        return res+dfs(n-1);
    }
}
