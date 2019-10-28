package com;

import java.util.List;

public class ReplaceWords {
    private static int R=26;
    private Node root;

    private class Node{
        private String val;
        private Node[] next;
        public Node(){
            this.val=null;
            this.next=new Node[R];
        }
    }

    public String get(String key){
        Node x=get(root,key,0);
        if (x==null){
            return null;
        }
        return x.val;
    }

    private Node get(Node x,String key,int d){
        if (x==null){
            return null;
        }
        /*for(int i=0;i<x.next.length;i++){
            if (x.next[i]!=null&&x.next[i].val!=null){
                return x.next[i];
            }
        }*/
        if (d==key.length()){
            return x;
        }
        char c=key.charAt(d);
        if (x.next[c-'a']!=null&&x.next[c-'a'].val!=null){
            return x.next[c-'a'];
        }
        return get(x.next[c-'a'],key,d+1);
    }

    public void put(String key){
        root=put(root,key,key,0);
    }

    private Node put(Node x,String key,String val,int d){
        if (x==null){
            x=new Node();
        }
        /**已存在的话，直接返回*/
        if (d==key.length()){
            x.val=val;
            return x;
        }
        char c=key.charAt(d);
        x.next[c-'a']=put(x.next[c-'a'],key,val,d+1);
        return x;
    }
    public String replaceWords(List<String> dict, String sentence) {
        /**首先构造字典树*/
        for (String s:dict){
            put(s);
        }
        String[] strs=sentence.split(" ");
        StringBuilder ans=new StringBuilder();
        for (String s:strs){
            String an=get(s);
            if (an!=null){
                ans.append(an+" ");
            }else {
                ans.append(s+" ");
            }
        }
        return ans.toString().trim();
    }
}
