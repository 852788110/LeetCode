package com;

import java.util.*;

/**

* @Description: 深度优先搜索

* @Param:

* @return:

* @Author: 刘洁

* @Date:

*/

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    private Map<Integer,Node> nodes;
    private HashSet<Integer> access;
    public Node cloneGraph(Node node) {
        nodes=new HashMap<>();
        access=new HashSet<>();
        List<Node> cNeighbors=new ArrayList<>();
        copy(node);
        DFS(node);
        return nodes.get(node.val);
    }

    private void DFS(Node node){
        access.add(node.val);
        for (Node n:node.neighbors){
            if (!access.contains(n.val)){
                copy(n);
                DFS(n);
            }
        }
    }
    private void copy(Node node){
        Node cNode;
        if (nodes.containsKey(node.val)){
            cNode=nodes.get(node.val);
        }else {
            List<Node> cNeighbors=new ArrayList<>();
            cNode=new Node(node.val,cNeighbors);
            nodes.put(node.val,cNode);
        }

        for (Node n:node.neighbors){
            /*若存在，则说明n在之前已经遍历过了*/
            if (nodes.containsKey(n.val)){
                cNode.neighbors.add(nodes.get(n.val));
            }else {
                List<Node> cNeighbors=new ArrayList<>();
                Node cn=new Node(n.val,cNeighbors);
                nodes.put(cn.val,cn);
                cNode.neighbors.add(cn);
            }
        }
    }
}
