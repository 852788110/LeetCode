package com;


import java.util.HashMap;
import java.util.Map;

/**

* @Description: 创建一个链表，来管理最近使用的情况，并且创建一个hash，来避免为了
                寻找某个结点，而带来的花销
* @Param:

* @return:

* @Author: 刘洁

* @Date:

*/
/*[[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]*/
public class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node pre;
        public Node(int key,int value){
            this.value=value;
            this.key=key;
        }
    }

    /**front:头结点  rear：尾结点
    * 头结点不带数据，value为-1*/
    private Node front;
    private Node rear;

    /**size:缓存的大小
    * nums:当前已存在数据的大小*/
    private int size;
    private int nums;

    /**哈希表来搜索目标结点*/
    private Map<Integer,Node> map;

    /**初始化链表*/
    private void init(int size){
        front=new Node(-1,-1);
        rear=front;
        this.size=size;
        this.nums=0;
        map=new HashMap<>();
    }

    /**插入到链表尾部
     * 这里并没有检查是否溢出*/
    private void insert(int k,int v){
        Node node=new Node(k,v);
        rear.next=node;
        node.pre=rear;
        rear=node;
        nums++;
        map.put(k,node);
    }

    /**删除目标结点*/
    private void delete(int v){
        Node node=map.get(v);
        Node nPre=node.pre;
        Node nNext=node.next;
        nPre.next=nNext;
        if (nNext!=null){
            nNext.pre=nPre;
        }else {
            /**这种情况只可能出现在node为尾结点*/
            rear=nPre;
        }
        nums--;
        map.remove(v);
    }

    /*删除第一个结点*/
    private void deleteHead(){
        int key=front.next.key;
        delete(key);
    }

    public LRUCache(int capacity) {
        init(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key)){
            Node node=map.get(key);
            delete(key);
            insert(node.key,node.value);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
           /* Node node=map.get(key);*/
            delete(key);
            insert(key,value);
            return;
        }
        if (nums>=size){
            deleteHead();
        }
        insert(key,value);
    }
}
