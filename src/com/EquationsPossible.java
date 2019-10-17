package com;

import java.util.HashMap;
import java.util.Map;

/** 

* @Description:

* @Param:  

* @return:  

* @Author: 刘洁

* @Date:  

*/ 

public class EquationsPossible {
    private int[] parent;
    private int[] rank;
    public boolean equationsPossible(String[] equations) {
        int lens=equations.length;
        parent=new int[27];
        rank=new int[27];
        for (int i=1;i<27;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for (int i=0;i<lens;i++){
            String str=equations[i];
            if (str.charAt(1)=='='){
                int p=str.charAt(0)-'a'+1;
                int q=str.charAt(3)-'a'+1;
                union(p,q);
            }
        }

        for (int i=0;i<lens;i++){
            String str=equations[i];
            if (str.charAt(1)=='!'){
                int p=str.charAt(0)-'a'+1;
                int q=str.charAt(3)-'a'+1;
                if (equation(p,q)){
                    return false;
                }
            }
        }
        return true;
    }

    private void union(int p,int q){
        int pRoot=find(p);
        int qRoot=find(q);
        if (pRoot!=qRoot){
            if (rank[pRoot]>rank[qRoot]){
                parent[qRoot]=pRoot;
                rank[pRoot]++;
            }else {
                parent[pRoot]=qRoot;
                rank[qRoot]++;
            }
        }
    }

    private boolean equation(int p,int q){
        int pRoot=find(p);
        int qRoot=find(q);
        if (pRoot==qRoot){
            return true;
        }
        return false;
    }

    private int find(int p){
        int pRoot=parent[p];
        while(parent[pRoot]!=pRoot){
            pRoot=parent[pRoot];
        }
        return pRoot;
    }
}
