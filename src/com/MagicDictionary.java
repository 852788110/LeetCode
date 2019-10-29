package com;

/** 

* @Description: 仔细审题

* @Param:  

* @return:  

* @Author: 刘洁

* @Date:  

*/ 

public class MagicDictionary {
    private static int R=26;
    /**stop:用于判断是否这个结点有单词*/
    private static class Node{
        boolean stop=false;
        Node[] nexts=new Node[R];
    }
    private Node root;
    public void insert(String key) {
        insert(root,key,0);
    }

    private Node insert(Node x,String key,int d){
        if (x==null){
            x=new Node();
        }
        if (d==key.length()){
            x.stop=true;
            return x;
        }
        char c=key.charAt(d);
        x.nexts[c-'a']=insert(x.nexts[c-'a'],key,d+1);
        return x;
    }

    /** Initialize your data structure here. */
    public MagicDictionary() {
        root=new Node();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String s:dict){
            insert(s);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        isPrefix=true;
        search(root,word,0);
        return isPrefix;
    }

    private boolean isPrefix;
    private void search(Node x,String key,int d){
        if (x==null){
            return;
        }
        if (x.stop==true){
            isPrefix=false;
            return;
        }
        if (d==key.length()){
            isPrefix=false;
            return;
        }
        char c=key.charAt(d);
        search(x.nexts[c-'a'],key,d+1);
    }
}
