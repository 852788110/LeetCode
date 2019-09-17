package com;

import java.util.*;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> queue=new LinkedList<>();
        Stack<Integer> stack=new Stack<>();
        List<List<Integer>> ans= new ArrayList<List<Integer>>();
        if (root==null) return  ans;
        List<Integer> res=new ArrayList<>();
        TreeNode node=root;
        int time=0,pretime=1;
        boolean reverse=false;
        while (node!=null||!queue.isEmpty()){
            if (node.left!=null){
                queue.add(node.left);
                time++;
            }
            if (node.right!=null){
                queue.add(node.right);
                time++;
            }
            pretime--;
            res.add(node.val);
            if (pretime==0){
                if (reverse){
                    for (int i=0;i<res.size();i++){
                        stack.push(res.get(i));
                    }
                    res=new ArrayList<>();
                    while(!stack.isEmpty()){
                        res.add(stack.pop());
                    }
                    reverse=false;
                }else reverse=true;
                ans.add(res);
                res=new ArrayList<>();
                pretime=time;
                time=0;
            }
            node=queue.poll();
        }
        return ans;
    }
}
