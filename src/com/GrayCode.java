package com;

import java.util.ArrayList;
import java.util.List;

/** 

* @Description: 这道题简直惊为天人 

* @Param:  

* @return:  

* @Author: 刘洁

* @Date:  

*/

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> ans=new ArrayList<>();
        ans.add(0);
        int head=1;
        for (int i=0;i<n;i++){
            for (int j=ans.size()-1;j>=0;j--){
                ans.add(head+ans.get(j));
            }
            head=head<<1;
        }
        return ans;
    }
}
