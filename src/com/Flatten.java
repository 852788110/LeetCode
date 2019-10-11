package com;

import sun.reflect.generics.tree.Tree;

public class Flatten {
    public void flatten(TreeNode root) {
        flt(root);
        TreeNode node=root;
        while(node!=null){
            node.left=null;
            node=node.right;
        }
    }

    private TreeNode flt(TreeNode node){
        TreeNode left=null,right=null;
        if (node.left!=null){
            left=flt(node.left);
            //left.left=null;
        }
        if (node.right!=null){
            right=flt(node.right);
            //right.left=null;
        }
        if (left!=null){
            node.right=left;
            TreeNode temp=left;
            while (temp.right!=null){
                temp=temp.right;
            }
            temp.right=right;
        }else{
            node.right=right;
        }
        return node;
    }
}
