package com;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        /*height用于记录层高*/
        int pre=0,cur=0,height=1;
        queue.add(root);
        pre++;
        /*iMax记录每层之和,max记录最大的层数之和*/
        int minHeight=1,max=Integer.MIN_VALUE,sum=0;
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            sum+=node.val;
            pre--;
            if (node.left!=null){
                queue.add(node.left);
                cur++;
            }

            if (node.right!=null){
                queue.add(node.right);
                cur++;
            }

            if (pre==0){
                pre=cur;
                cur=0;
                if (sum>max){
                    max=sum;
                    minHeight=height;
                }
                sum=0;
                height++;
            }
        }
        return minHeight;
    }
}
