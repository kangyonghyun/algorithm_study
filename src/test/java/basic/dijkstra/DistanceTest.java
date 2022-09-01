package basic.dijkstra;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class DistanceTest {

    @Test
    void printMinCost() {
        int n = 6;
        Graph graph = new Graph(n);
        graph.add(1, new Edge(2, 12));
        graph.add(1, new Edge(3, 4));
        graph.add(2, new Edge(1, 2));
        graph.add(2, new Edge(3, 5));
        graph.add(2, new Edge(5, 5));
        graph.add(3, new Edge(4, 5));
        graph.add(4, new Edge(2, 2));
        graph.add(4, new Edge(5, 5));
        graph.add(6, new Edge(4, 5));

        graph.getMinCost();
        graph.printMinCost();
    }

    static class Edge implements Comparable<Edge> {
        int vertex;
        int cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }


    static class Graph {
        List<List<Edge>> edges = new ArrayList<>();

        int dis[];

        public Graph(int n) {
            dis = new int[n + 1];
            Arrays.fill(dis, Integer.MAX_VALUE);
            for (int i = 0; i <= n; i++) {
                edges.add(new ArrayList<>());
            }
        }

        public void add(int i, Edge edge) {
            edges.get(i).add(edge);
        }

        public void printMinCost() {
            for (int i = 2; i < dis.length; i++) {
                if (dis[i] != Integer.MAX_VALUE) {
                    System.out.println(i + " : " + dis[i]);
                } else {
                    System.out.println(i + " : " + "Impossible");
                }
            }
        }

        public void getMinCost() {
            PriorityQueue<Edge> pQue = new PriorityQueue<>();
            pQue.add(new Edge(1, 0));
            dis[1] = 0;
            while (!pQue.isEmpty()) {
                Edge tmp = pQue.poll();
                int now = tmp.vertex;
                int nowCost = tmp.cost;
                if (nowCost > dis[now]) {
                    continue;
                }
                for (Edge edge : edges.get(now)) {
                    int totalCost = nowCost + edge.cost;
                    int vertex = edge.vertex;
                    if (dis[vertex] > totalCost) {
                        dis[vertex] = totalCost;
                        pQue.offer(new Edge(vertex, totalCost));
                    }
                }
            }
        }
    }
}