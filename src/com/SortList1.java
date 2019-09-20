package com;

public class SortList1 {
    public ListNode sortList(ListNode head) {
        int count=0;
        ListNode node=head;
        while(node!=null){
            count++;
            node=node.next;
        }
        return sortList(head,count);
    }

    ListNode sortList(ListNode head,int count){
        if (count<=1) return head;
        int mid=count/2+1,i=1;
        ListNode leftEnd=head,node=head;
        while(i<=mid){
            i++;
            leftEnd=leftEnd.next;
        }
        ListNode rightStart=leftEnd.next;
        leftEnd.next=null;
        return merge(sortList(head,mid),sortList(rightStart,count-mid));
    }

    ListNode merge(ListNode l1,ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head;
        if (l1.val <= l2.val) {
            head = l1;
            l1.next = merge(l1.next, l2);
        } else {
            head = l2;
            l2.next = merge(l1, l2.next);
        }
        return head;
    }
}
