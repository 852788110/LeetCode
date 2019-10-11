package com;

/*
* 由于链表是有序的，因此每次加入的结点必然是最右边的结点
*   可以设置尾结点来更快速的加入
* */
public class SortedListToBST {
    /*对于这道题的官方题解，我真的是贵了*/
    public TreeNode sortedListToBST(ListNode head) {
        ListNode node=head;
        int lens=0;
        while (node!=null){
            lens++;
            node=node.next;
        }

        node=head;
        int[] nums=new int[lens];
        for (int i=0;i<lens;i++){
            nums[i]=node.val;
            node=node.next;
        }
        return sortList(nums,0,lens-1);
    }

    private TreeNode sortList(int[] nums,int start,int end){
        if (start>end){
            return null;
        }
        int mid=(start+end)/2;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=sortList(nums,start,mid-1);
        node.right=sortList(nums,mid+1,end);
        return node;
    }
}
