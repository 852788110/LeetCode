package com;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossibleFBT {
    /*
    * 这道题目采用递归的方法*/
    /*public List<TreeNode> allPossibleFBT(int N) {
        Map<Integer,List<TreeNode>> res=new HashMap<>();
        for (int i=2;i<=N;i++){
            res.put(i,null);
        }
        return allPossible(N,res);
    }

    private List<TreeNode> allPossible(int N,Map<Integer,List<TreeNode>> res){
        List<TreeNode> ans=new ArrayList<>();
        if (N%2==0) return ans;
        if (N==1){
            ans.add();
        }
        for (int i=1;i<N;i++){
            *//*List<TreeNode> temp1=allPossibleFBT(i);
            List<TreeNode> temp2=allPossibleFBT(N-i);*//*
            List<TreeNode> temp1,temp2;
            if (res.get(i)==null){
               res.replace(i,allPossible(i,res));
            }
            temp1 =res.get(i);

            if (res.get(N-i)==null){
                res.replace(N-i,allPossible(N-i,res));
            }
            temp2=res.get(N-i);

            for (TreeNode s:temp1) {
                for (TreeNode t:temp2) {
                    TreeNode tree=new TreeNode(0);
                    tree.left=s;
                    tree.right=t;
                    ans.add(tree);
                }
            }
        }
        res.put(N,ans);
        return ans;
    }*/
}
