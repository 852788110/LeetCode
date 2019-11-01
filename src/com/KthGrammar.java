package com;

public class KthGrammar {
    public int kthGrammar(int N, int K) {
        int nums=(int)Math.pow(2,N-1);
        boolean change=false;
        while (nums>2){
            nums=nums/2;

            if (K>nums){
                K=K-nums;
                if (change) {
                    change = false;
                } else {
                    change = true;
                }
            }
        }
        if (K==1){
            if (change){
                return 1;
            }else {
                return 0;
            }
        }else {
            if (change){
                return 0;
            }else {
                return 1;
            }
        }
    }
}
