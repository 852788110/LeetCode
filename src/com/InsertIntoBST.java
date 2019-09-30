package com;

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node=root,pre=root;
        while(node!=null){
            if (node.val<val){
                pre=node;
                node=node.right;
            }else if (node.val>val){
                pre=node;
                node=node.left;
            }else {
                return root;
            }
        }
        if (pre.val<val){
            pre.right=new TreeNode(val);
        }else {
            pre.left=new TreeNode(val);
        }
        return root;
    }
}
