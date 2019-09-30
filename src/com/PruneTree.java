package com;

public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        boolean res=prune(root);
        if (!res) return null;
        return root;
    }

    private boolean prune(TreeNode node){
        boolean i1=false,i2=false;
        if (node.left!=null){
            i1=prune(node.left);
            if (!i1){
                node.left=null;
            }
        }

        if (node.right!=null){
            i2=prune(node.right);
            if (!i2){
                node.right=null;
            }
        }
        return i1||i2||(node.val!=0);
    }
}
