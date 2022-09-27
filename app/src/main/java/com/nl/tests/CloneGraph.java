package com.nl.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

    public static void main(String[] args) {

    }

    public static Node cloneGraph(Node node) {

        HashMap<Node, Node> nodeMap = new HashMap<>();
        return node != null ? clone(node, nodeMap) : null;
    }

    public static Node clone(Node node, HashMap<Node, Node> nodeMap) {

        if(nodeMap.containsKey(node))
            return nodeMap.get(node);

        Node newNode = new Node(node.val);
        nodeMap.put(node, newNode);

        List<Node> neighbors = node.neighbors;
        List<Node> newNeighbors = newNode.neighbors;

        for (Node neighbor: neighbors) {
            newNeighbors.add(clone(neighbor, nodeMap));
        }

        return newNode;
    }

    static class Node {

        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}