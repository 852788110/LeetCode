package com;

import java.util.ArrayList;
import java.util.List;

public class PancakeSort {
    public List<Integer> pancakeSort(int[] A) {
        int lens=A.length,end=lens-1;
        List<Integer> ans=new ArrayList<>();
        for (int i=0;i<lens;i++){
            int max=max(end,A);
            if (max==end) {
                end--;
                continue;
            }
            reverse(0,max,A);
            ans.add(max+1);
            reverse(0,end,A);
            ans.add(end+1);
            end--;
        }
        return ans;
    }

    private int max(int end,int[] A){
        int max=0;
        for (int i=0;i<=end;i++){
            if (A[i]>A[max]) max=i;
        }
        return max;
    }

    private void reverse(int start,int end,int[] A){
        int mid=(start+end)/2,temp=0;
        for (int i=0;i<=mid;i++){
            temp=A[start+i];
            A[start+i]=A[end-i];
            A[end-i]=temp;
        }
    }
}
