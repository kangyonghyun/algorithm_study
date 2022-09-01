package basic.dijkstra;

import java.util.*;

public class Distance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        Graph graph = new Graph(n);
        for (int i = 0; i < m; i++) {
            graph.add(sc.nextInt(), new Edge(sc.nextInt(), sc.nextInt()));
        }
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
