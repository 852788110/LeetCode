package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyLinkedList {
    class Node{
        int val;
        Node next;
        Node parent;

        public Node(int val){
            this.val=val;
        }
    }

    private Node front;
    private Node rear;

    /**当前元素数量*/
    private int nums;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        front=new Node(-1);
        rear=front;
        nums=0;
    }

    private boolean isEmpty(){
        return nums==0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (isEmpty()||index>=nums){
            return -1;
        }
        /**如果nums-index<index，则从尾部开始查找*/
        if (nums-index-1<index){
            int dIndex=nums-index-1;
            Node node=rear;
            while (dIndex>0){
                node=node.parent;
                dIndex--;
            }
            return node.val;
        }else {
            Node node=front.next;
            while (index>0){
                node=node.next;
                index--;
            }
            return node.val;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node=new Node(val);
        if (isEmpty()){
            front.next=node;
            node.parent=front;
            rear=node;
        }else {
            Node temp=front.next;
            temp.parent=node;
            node.next=temp;
            node.parent=front;
            front.next=node;
        }
        nums++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(nums,val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index>nums){
            return;
        }
        if (index<0){
            addAtHead(val);
        }
        Node node=new Node(val);
        if (index==nums){
            rear.next=node;
            node.parent=rear;
            rear=node;
            nums++;
            return;
        }
        if (isEmpty()){
            front.next=node;
            node.parent=front;
            rear=node;
            nums++;
            return;
        }

        if (nums-index<index){
             Node temp=rear;
             int dIndex=nums-index;
             while (dIndex>0){
                 temp=temp.parent;
                 dIndex--;
             }
             /**得到的temp是待插入结点的头结点*/
             Node tNext=temp.next;
             node.next=tNext;
             if (tNext!=null) {
                 tNext.parent = node;
             }
             temp.next=node;
             node.parent=temp;
        }else {
            Node temp=front;
            while (index>0){
                temp=temp.next;
                index--;
            }
            /**得到的temp同样是待插入结点的头结点*/
            Node tNext=temp.next;
            node.next=tNext;
            if (tNext!=null) {
                tNext.parent = node;
            }
            temp.next=node;
            node.parent=temp;
        }
        nums++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (isEmpty()){
            return;
        }
        if (index>=nums){
            return;
        }
        /**如果index指向的是尾结点*/
        if (index==nums-1){
            Node node= rear.parent;
            node.next=null;
            rear=node;
            nums--;
            return;
        }
        /**得到的是待删除结点的母结点*/
        Node node=front;
        while (index>0){
            node=node.next;
            index--;
        }
        Node temp=node.next.next;
        node.next=temp;
        temp.parent=node;
        nums--;
    }
}
