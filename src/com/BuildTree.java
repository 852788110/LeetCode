package com;


/**

* @Description: 首先，在后序遍历中寻找中间结点，然后分别在中序遍历中进行查找

* @Param:

* @return:

* @Author: 刘洁

* @Date:

*/

public class BuildTree {
    private static int index=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index=inorder.length-1;
        return buildTree(inorder,postorder,0,inorder.length-1);
    }

    private TreeNode buildTree(int[] inorder,int[] postorder,int start,int end){
        if (start>end){
            return null;
        }
        int temp=postorder[index],mid=0;
        for (int i=start;i<=end;i++){
            if (inorder[i]==temp){
                mid=i;
                break;
            }
        }
        TreeNode node=new TreeNode(inorder[mid]);
        index--;
        node.right=buildTree(inorder,postorder,mid+1,end);
        node.left=buildTree(inorder,postorder,start,mid-1);
        return node;
    }
}
