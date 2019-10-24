package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
    class Node{
        Map<Character,Node> sons;
    }
    Map<Character,Node> root;
    /*当search某个值时，若最后一个node中没有!时，则说明没有这个单词*/
    private final char stop='!';
    /** Initialize your data structure here. */
    public Trie() {
        root=new HashMap<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node;
        if (root.containsKey(word.charAt(0))){
            node=root.get(word.charAt(0));
        }else {
            Node son=new Node();
            root.put(word.charAt(0),son);
            node=root.get(word.charAt(0));
        }
        for (int i=1;i<word.length();i++){
            node=inse(word.charAt(i),node);
        }

        if (node.sons==null){
            node.sons=new HashMap<>();
        }
        node.sons.put('!',null);
    }

    private Node inse(char key,Node node){
        if (node.sons==null){
            node.sons=new HashMap<>();
        }
        if (node.sons.containsKey(key)){
            return node.sons.get(key);
        }else {
            Node son=new Node();
            node.sons.put(key,son);
            return son;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node=root.get(word.charAt(0));
        if (node==null){
            return false;
        }

        for (int i=1;i<word.length();i++){
            if (node.sons==null){
                return false;
            }
            if (!node.sons.containsKey(word.charAt(i))){
                return false;
            }
            node=node.sons.get(word.charAt(i));
        }
        if (!node.sons.containsKey(stop)){
            return false;
        }
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node=root.get(prefix.charAt(0));
        if (node==null){
            return false;
        }

        for (int i=1;i<prefix.length();i++){
            if (node.sons==null){
                return false;
            }
            if (!node.sons.containsKey(prefix.charAt(i))){
                return false;
            }
            node=node.sons.get(prefix.charAt(i));
        }
        return true;
    }
}
