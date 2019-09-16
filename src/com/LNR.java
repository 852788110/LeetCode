package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*public class LNR {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode node=root;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        ArrayList<Integer> list1=new ArrayList<Integer>();
       while(node!=null||!stack.isEmpty()){
           if (node!=null){
               stack.push(node);
               node=node.left;
           }else {
               node=stack.pop();
               list1.add(node.val);
               node=node.right;
           }
       }
       return list1;
    }
}*/
