package com;

public class BSTIterator {
    private TreeNode root;
    public BSTIterator(TreeNode root) {
        this.root=root;
    }

    /** @return the next smallest number */
    /*若有左子树，则遍历左子树
    * 若无左子树，则最小值为根节点*/
    public int next() {
        TreeNode node=root,pre=node;
        while(node.left!=null){
            pre=node;
            node=node.left;
        }
        /*int ans=node.val;
        node=node.right;
        return ans;*/
        if (node==pre){
            int ans=node.val;
            root=root.right;
            return ans;
        }
        int ans=node.val;
        if (node.right!=null){
            pre.left=node.right;
        }else {
            pre.left=null;
        }
        return ans;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return root!=null;
    }
}
