package com;

import java.util.ArrayList;
import java.util.List;

/**

* @Description: 先尝试使用深度优先搜索,这种算法速度太感人了，换一种

* @Param:

* @return:

* @Author: 刘洁

* @Date:

*/

public class Combine {
    private int n;
    private int k;
    private List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        this.n=n;
        this.k=k;
        ans=new ArrayList<>();
        for (int i=1;i<=n;i++){
            List<Integer> list=new ArrayList<>();
            dfs(i,1,list);
        }
        return ans;
    }

    private void dfs(int v,int d,List<Integer> prelist){
        prelist.add(v);
        if (d==k){
            ans.add(prelist);
            return;
        }
        for (int i=v+1;i<=n;i++){
            List<Integer> list=new ArrayList<>();
            for (int t:prelist){
                list.add(t);
            }
            dfs(i,d+1,list);
        }
    }
}
