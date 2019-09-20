package com;

import java.util.PriorityQueue;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head==null) return head;
        PriorityQueue<ListNode> queue=new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode node=head;
        while(node!=null){
            queue.add(node);
            node=node.next;
        }
        ListNode first=queue.poll();
        ListNode rear=first;
        while(!queue.isEmpty()){
            rear.next=queue.poll();
            rear=rear.next;
        }
        rear.next=null;
        return first;
    }
}

/*
if (head == null) return head;
        ListNode countNode = head;
        //计算出链表的长度
        int count = 0;
        while (countNode != null) {
            count++;
            countNode = countNode.next;
        }
        return sortList(head, count);
    }
    */
/**
     * 排序链表
     * @param head
     * @param count
     * @return
     *//*

private ListNode sortList(ListNode head, int count) {
    //递归结束条件
    if (count <= 1) return head;
    ListNode leftEnd = head;
    for (int i = 0; i < count / 2-1; i++) {
        leftEnd = leftEnd.next;
    }
    ListNode rightStart = leftEnd.next;
    //断链，如果不断链，各种判断让你死去活来
    leftEnd.next = null;
    //合并两个已经排完序的链表
    //第二个链表的长度为count - count / 2，不能直接是count / 2，奇数计算会错误
    return merge(
            sortList(head, count / 2),
            sortList(rightStart, count - count / 2)
    );
}


    */
/**
     * 合并有序的链,使用递归更加简洁和易懂，每次只比较两个链表的链头
     *
     * @param l1
     * @param l2
     * @return
     *//*

    private ListNode merge(ListNode l1, ListNode l2) {
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

        作者：tas
        链接：https://leetcode-cn.com/problems/sort-list/solution/java-shi-yong-gui-bing-pai-xu-by-tas/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
