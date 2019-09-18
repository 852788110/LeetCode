package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if (root==null) return ans;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;
        while(node!=null||!stack.isEmpty()){
            if (node!=null){
                ans.add(node.val);
                stack.push(node);
                node=node.left;
            }else {
                node=stack.pop();
                node=node.right;
            }
        }
        return ans;
    }
}
