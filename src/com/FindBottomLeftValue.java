package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        Map<Integer,Integer> res=new HashMap<>();
        findBottom(res,0,root);
        int max=0;
        for (int s:res.keySet()) {
            if (s>max){
                max=s;
            }
        }
        return res.get(max);
    }

    private void findBottom(Map<Integer,Integer> res, int height, TreeNode node) {
        if (node.left != null) {
            findBottom(res, height + 1, node.left);
        }
        if (node.left==null&&!res.containsKey(height)) {
            res.put(height,node.val);
        }
        if (node.right != null) {
            findBottom(res, height + 1, node.right);
        }
    }
}
