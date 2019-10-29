package com;

public class MapSum {
    private static int R=26;
    /**stop:用于判断是否这个结点有单词*/
    private static class Node{
        int val;
        boolean stop=false;
        Node[] nexts=new Node[R];
    }
    private Node root;
    /** Initialize your data structure here. */
    public MapSum() {
        root=new Node();
    }

    public void insert(String key, int val) {
        insert(root,key,val,0);
    }

    private Node insert(Node x,String key,int val,int d){
        if (x==null){
            x=new Node();
        }
        if (d==key.length()){
            x.val=val;
            x.stop=true;
            return x;
        }
        char c=key.charAt(d);
        x.nexts[c-'a']=insert(x.nexts[c-'a'],key,val,d+1);
        return x;
    }

    public int sum(String prefix) {
        ans=0;
        Node node=get(root,prefix,0);
        if (node!=null&&node.stop){
            ans+=node.val;
        }
        collect(node);
        return ans;
    }

    private int ans=0;
    private void collect(Node x){
        if (x==null){
            return;
        }
        for (int i=0;i<R;i++){
            if (x.nexts[i]!=null){
                if (x.nexts[i].stop==true){
                    ans+=x.nexts[i].val;
                }
                collect(x.nexts[i]);
            }
        }
    }

    private Node get(Node x,String key,int d){
        if (x==null){
            return null;
        }
        if (key.length()==d){
            return x;
        }
        char c=key.charAt(d);
        return get(x.nexts[c-'a'],key,d+1);
    }
}
