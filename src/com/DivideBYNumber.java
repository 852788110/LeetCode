package com;

public class DivideBYNumber {
    public int solution(int k,int start,int end){
        int cur=k;
        int sum=0;
        while (cur<=end){
            cur+=k;
            sum++;
        }
        return sum;
    }
}
