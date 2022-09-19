package leetcode.graph;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class CloneGraphTest {

    @Test
    void solution1() {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        first.neighbors.add(second);
        first.neighbors.add(fourth);
        second.neighbors.add(first);
        second.neighbors.add(third);
        third.neighbors.add(second);
        third.neighbors.add(fourth);
        fourth.neighbors.add(first);
        fourth.neighbors.add(third);

        Node cloneNode = cloneGraph(first);
        assertThat(cloneNode).isNotEqualTo(first);

        Queue<Node> que = new LinkedList<>();
        que.offer(cloneNode);
        List<Node> nodes = new ArrayList<>();
        nodes.add(cloneNode);
        while (!que.isEmpty()) {
            Node cur = que.poll();
            System.out.println(cur.val);
            for (Node neighbor : cur.neighbors) {
                if (!nodes.contains(neighbor)) {
                    que.offer(neighbor);
                }
                nodes.add(neighbor);
            }
        }
    }
    @Test
    void otherTest() {
        assertThat(cloneGraph(null)).isEqualTo(null);
        assertThat(cloneGraph(new Node(1)).val).isEqualTo(1);
        assertThat(cloneGraph(new Node(1)).neighbors).size().isEqualTo(0);
    }

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