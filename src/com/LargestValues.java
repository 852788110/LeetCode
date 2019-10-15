package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if (root==null){
            return ans;
        }
        int preNum=0,curNum=0,max=Integer.MIN_VALUE;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        preNum++;
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            preNum--;
            if (node.val>max){
                max=node.val;
            }
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
                ans.add(max);
                max=Integer.MIN_VALUE;
            }
        }
        return ans;
    }
}
