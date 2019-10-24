package com;

public class CountLetter {
    public int[] count(String letters){
        int N=letters.length();
        int[] ans=new int[26];
        for (int i=0;i<N;i++){
            char letter=letters.charAt(i);
            int index=letter-'A';
            ans[index]++;
        }
        return ans;
    }
}
