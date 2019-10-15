package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        int preNum=0,curNum=0;
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        preNum+=1;
        ans.add(root.val);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            preNum--;
            if (node.right!=null){
                queue.add(node.right);
                curNum++;
            }
            if (node.left!=null){
                queue.add(node.left);
                curNum++;
            }
            if (preNum==0){
                preNum=curNum;
                curNum=0;
                if (!queue.isEmpty()) {
                    ans.add(queue.peek().val);
                }
            }
        }
        return ans;
    }
}
