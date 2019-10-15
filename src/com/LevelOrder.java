package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> an=new ArrayList<>();
        int preNum=0,curNum=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        preNum++;
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            an.add(node.val);
            preNum--;
            if (node.left!=null){
                queue.add(node.left);
                curNum++;
            }
            if (node.right!=null){
                queue.add(node.right);
                curNum++;
            }
            if (preNum==0){
                preNum=curNum;
                curNum=0;
                ans.add(an);
                an=new ArrayList<>();
            }
        }
        return ans;
    }
}
