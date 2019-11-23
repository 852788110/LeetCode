package com;

import java.util.List;

/** 

* @Description: 这道题理解错误

* @Param:  

* @return:  

* @Author: 刘洁

* @Date:  

*/ 

public class MaxLength {
    public int maxLength(List<String> arr) {
        boolean[] onMarked=new boolean[arr.size()];
        if (arr.size()==1){
            int ans=arr.get(0).length();
            return ans;
        }
        if (arr.size()>1){
            int max=0,second=0,sum=0;
            int i;
            for (i=1;i<arr.size();i++){
                if (onMarked[i]==false){
                    if (arr.get(i).length()>arr.get(max).length()){
                        max=i;
                    }
                }
            }
            onMarked[max]=true;
            sum+=arr.get(max).length();
            for (i=0;i<arr.size();i++){
                if (onMarked[i]==false){
                    if (arr.get(i).length()>arr.get(second).length()){
                        second=i;
                    }
                }
            }
            sum+=arr.get(second).length();
            return sum;
        }
        return 0;
    }
}
