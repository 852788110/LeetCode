package com;

/** 

* @Description: 这道题我一直没看懂他的题目，

* @Param:  

* @return:  

* @Author: 刘洁

* @Date:  

*/ 

public class BstToGst {
    public TreeNode bstToGst(TreeNode root) {
        sum=0;
        RNL(root);
        return root;
    }
    private int sum;
    private void RNL(TreeNode node){
        if (node.right!=null){
            RNL(node.right);
        }

        node.val=sum+node.val;
        sum=node.val;
        if (node.left!=null){
            RNL(node.left);
        }
    }
}
