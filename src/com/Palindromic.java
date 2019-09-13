package com;

public class Palindromic {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int num=0;
        int temp=x;
        while(temp>0){
            temp=temp/10;
            num++;
        }
        int left=0,right=0;
        while(x>0){
            left=(int)(x/(Math.pow(10,num-1)));
            right=x%10;
            if(left!=right) return false;
            x=(int)(x%(Math.pow(10,num-1)));
            x=x/10;
            num-=2;
        }
        return true;
    }
}
