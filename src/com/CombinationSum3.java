package com;

import java.util.ArrayList;
import java.util.List;

/**

* @Description: 这道题尝试回溯算法

* @Param:

* @return:

* @Author: 刘洁

* @Date:

*/

public class CombinationSum3 {
    private int n,k;
    private List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.n=n;
        this.k=k;
        ans=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        trackBack(1,0,(ArrayList<Integer>) list);
        return ans;
    }

    private void trackBack(int v,int sum,ArrayList<Integer> list){
        if (k==list.size()){
            if (sum==n){
                ans.add((List<Integer>) list.clone());
            }
            return;
        }
        if (sum>=n){
            return;
        }
        for (int i=v;i<=n-(k-list.size())+1;i++){
            list.add(i);
            sum+=i;
            trackBack(i+1,sum,list);
            list.remove(list.size()-1);
            sum-=i;
        }
    }
}
