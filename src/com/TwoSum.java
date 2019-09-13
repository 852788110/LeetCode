package com;

import javax.xml.soap.Node;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    }
}*/

public class TwoSum {
    public ListNode node=null;
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

    //构造函数
    public TwoSum(){
        this.node=null;
    }

    //采用的是头插法,得到的数据与输入的数据顺序是相反的
    public void addNode(int key){
        ListNode newnode=new ListNode(key);
        if (node==null){
            node=newnode;
        }else {
            newnode.next=node;
            node=newnode;
        }
    }

    public String toString() {
        String resultstring="";
        ListNode tempnode=node;
        while (tempnode!=null){
            resultstring+=tempnode.val+" ";
            tempnode=tempnode.next;
        }
        return  resultstring;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1;
        ListNode temp2=l2;
        boolean carry=false;
        int sumtemp=temp1.val+temp2.val;
        temp1=temp1.next;
        temp2=temp2.next;
        if (sumtemp>=10) {carry=true; sumtemp-=10;}
        ListNode newList=new ListNode(sumtemp);
        ListNode tempnew=newList;
        while(temp1!=null&&temp2!=null){
            if (carry) sumtemp=temp1.val+temp2.val+1;
            else sumtemp=temp1.val+temp2.val;

            if (sumtemp>=10){
                carry=true;
                sumtemp-=10;
            }else carry=false;

            ListNode tempold=tempnew;
            tempnew=new ListNode(sumtemp);
            tempold.next=tempnew;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        //处理之后temp1或者temp2为空的情况
        if (temp1!=null){
//            tempnew.next=temp1;
            while(carry&temp1!=null){
                sumtemp=temp1.val+1;
                if (sumtemp>=10){
                    sumtemp-=10;
                    carry=true;
                }
                else carry=false;
                ListNode tempold=tempnew;
                tempnew=new ListNode(sumtemp);
                tempold.next=tempnew;
                temp1=temp1.next;
            }
            if (temp1!=null) tempnew.next=temp1;
        }
        if (temp2!=null){
            while(carry&temp2!=null){
                sumtemp=temp2.val+1;
                if (sumtemp>=10){
                    sumtemp-=10;
                    carry=true;
                }
                else carry=false;
                ListNode tempold=tempnew;
                tempnew=new ListNode(sumtemp);
                tempold.next=tempnew;
                temp2=temp2.next;
            }
            if (temp2!=null) tempnew.next=temp2;
        }
        if (carry){
            ListNode tempold=tempnew;
            tempnew=new ListNode(1);
            tempold.next=tempnew;
        }
        return newList;
    }
}
