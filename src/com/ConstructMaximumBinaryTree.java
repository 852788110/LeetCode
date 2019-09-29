package com;

public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int lens=nums.length;
        return constructMax(0,lens-1,nums);
    }

    /*首先，找到le,hl区间的最大值
    * 将le到最大值下标的元素作为左子树
    * 将最大值下标的元素作为右子树*/
    private TreeNode constructMax(int le,int hl,int[] nums){
        if (le>hl) return null;
        int max=le;
        for (int i=le;i<=hl;i++){
            if (nums[i]>nums[max]) max=i;
        }
        TreeNode maxNode=new TreeNode(nums[max]);
        maxNode.left=constructMax(le,max-1,nums);
        maxNode.right=constructMax(max+1,hl,nums);
        return maxNode;
    }
}
