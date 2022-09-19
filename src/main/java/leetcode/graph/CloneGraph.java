package leetcode.graph;

import java.util.*;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node newNode = new Node(node.val);
        Map<Integer, Node> map = new HashMap<>();
        map.put(newNode.val, newNode);

        Queue<Node> que = new LinkedList<>();
        que.offer(node);

        while (!que.isEmpty()) {
            Node cur = que.poll();
            for (Node neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor.val)) {
                    map.put(neighbor.val, new Node(neighbor.val));
                    que.offer(neighbor);
                }
                map.get(cur.val).neighbors.add(map.get(neighbor.val));
            }
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
