package com;

/*设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。


        push(x) -- 将元素 x 推入栈中。
        pop() -- 删除栈顶的元素。
        top() -- 获取栈顶元素。
        getMin() -- 检索栈中的最小元素。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/min-stack
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Node{
    public int key;
    public Node next;
}

public class MinStack {
    private Node head;
    private int minnum=Integer.MAX_VALUE;
    public MinStack() {
        head=new Node();
        head.next=null;
    }

    public void push(int x) {
        Node temp=new Node();
        temp.key=x;
        temp.next=head.next;
        head.next=temp;
        if (minnum>x) minnum=x;
    }

    public void pop() {
        Node temp=head.next;
        if (temp.key==minnum){
            Node de=temp.next;
            minnum=Integer.MAX_VALUE;
            while(de!=null){
                if (minnum>de.key){
                    minnum=de.key;
                }
                de=de.next;
            }
        }
        head.next=temp.next;
    }

    public int top() {
        return head.next.key;
    }

    public int getMin() {
        return minnum;
    }
}
