package com;

public class InsertionSortList {
    private ListNode traver=null;
    private ListNode first=null;
    private void insert(ListNode left,ListNode right){
        traver=traver.next;
        //查找到left前一个结点
        ListNode preleft=first;
        while(preleft!=left){preleft=preleft.next;}
        //查找到right前一个结点
        ListNode preright=left;
        while(preright!=right){preright=preright.next;}

        //如果left等于first
        if (left==first){
            preright.next=right.next;
            right.next=first;
            first=right;
        }else {
            preright.next=right.next;
            right.next=left;
            preleft.next=right;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        first=head;
        traver=head.next;
        while(traver!=null){
            ListNode left=first;
            while(left.val<traver.val&&left!=traver){
                left=left.next;
            }
            ListNode right=traver;
            //将traver插入到left前面
            insert(left,right);
        }
        return first;
    }
}
