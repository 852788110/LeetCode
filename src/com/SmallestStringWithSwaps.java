package com;

import java.util.*;

/**

* @Description: 这道题我认为可以使用并查集和排序

* @Param:

* @return:

* @Author: 刘洁

* @Date:

*/

public class SmallestStringWithSwaps {
    private int[] parent;
    private int[] rank;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int lens=s.length();
        parent=new int[lens];
        rank=new int[lens];
        for (int i=0;i<lens;i++){
            rank[i]=1;
            parent[i]=i;
        }
        for (List<Integer> items:pairs) {
            int p=items.get(0);
            int q=items.get(1);
            union(p,q);
        }
        List<List<Integer>> res=new ArrayList<>();
        for (int i=0;i<lens;i++){
            List<Integer> item=new ArrayList<>();
            res.add(item);
        }

        for (int i=0;i<lens;i++){
            int iRoot=find(i);
            List<Integer> temp=res.get(iRoot);
            temp.add(i);
        }

        StringBuilder stringBuilder=new StringBuilder(s);
        for (List<Integer> items:res) {
            if (items.isEmpty()){
                continue;
            }
            char[] temp=new char[items.size()];
            int i=0;
            for (Integer t:items) {
                temp[i]=s.charAt(t);
                i++;
            }
            Arrays.sort(temp);
            i=0;
            for (Integer t:items){
                stringBuilder.setCharAt(t,temp[i]);
                i++;
            }
        }
        return stringBuilder.toString();
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

    private int find(int p){
        int pRoot=parent[p];
        while(parent[pRoot]!=pRoot){
            pRoot=parent[pRoot];
        }
        return pRoot;
    }
}
