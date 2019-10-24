package com;

/** 

* @Description: 双端循环队列，使用链表实现 

* @Param:  

* @return:  

* @Author: 刘洁

* @Date:  

*/ 

public class MyCircularDeque {
    class Node{
        int value;
        Node next;
        public Node(int value){
            this.value=value;
        }
    }

    /** front:头结点   reat：尾结点
     * 头结点是空结点，里面不存放数据*/
    private Node front;
    private Node rear;

    /** size:队列的容量  nums:当前队列所拥有的元素*/
    private int size;
    private int nums;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        front=new Node(-1);
        rear=front;
        rear.next=front;
        this.size=k;
        this.nums=0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()){
            return false;
        }
        Node node=new Node(value);
        if (isEmpty()){
            front.next=node;
            rear=node;
            rear.next=front;
        }else {
            node.next=front.next;
            front.next=node;
        }
        nums++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()){
            return false;
        }
        Node node=new Node(value);
        if (isEmpty()){
            rear=node;
            front.next=rear;
            rear.next=front;
        }else {
            rear.next=node;
            rear=rear.next;
            rear.next=front;
        }
        nums++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()){
            return false;
        }
        front.next=front.next.next;
        nums--;
        if (nums==0){
            rear=front;
            rear.next=front;
        }
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()){
            return false;
        }
        Node node=front;
        while(node.next!=rear){
            node=node.next;
        }
        node.next=rear.next;
        rear=node;
        nums--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return front.next.value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return rear.value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return nums==0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return nums==size;
    }
}
