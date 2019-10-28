package com;

public class MyCircularQueue {
    /**
     * nums:用来存储数据  size：队列的容量  num:现存数据的数量
     */
    private int[] nums;
    private int size;
    private int num;

    /**head指向第一个元素，rear指向最后一个元素的下一个位置*/
    private int head;
    private int rear;
    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        this.size = k;
        num = 0;
        nums = new int[size];
        head=0;
        rear=head;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        rear=rear%size;
        nums[rear]=value;
        rear++;
        num++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        head=head%size;
        head++;
        num--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()){
            return -1;
        }
        head=head%size;
        return nums[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        int last=rear-1;
        last=last%size;
        return nums[last];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return num == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return num >= size;
    }
}
