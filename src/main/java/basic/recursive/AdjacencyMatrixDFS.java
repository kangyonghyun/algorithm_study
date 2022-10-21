package basic.recursive;

import java.util.Scanner;

public class AdjacencyMatrixDFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        int edge = sc.nextInt();
        int[][] graph = new int[node + 1][node + 1];
        for (int i = 0; i < edge; i++) {
            int to = sc.nextInt();
            int from = sc.nextInt();
            graph[to][from] = 1;
        }
        AdjacencyMatrix dfs = new AdjacencyMatrix(node, graph);
        System.out.println(dfs.getResultDFS());
    }

    static class AdjacencyMatrix {
        int node;
        int[][] graph;
        int[] check;

        public AdjacencyMatrix(int node, int[][] graph) {
            this.node = node;
            this.graph = graph;
            this.check = new int[node + 1];
            this.check[1] = 1;
        }

        public int getResultDFS() {
            Count count = new Count();
            DFS(1, count);
            return count.count;
        }

        private void DFS(int vertex, Count count) {
            if (vertex == node) {
                count.count++;
            } else {
                for (int i = 1; i <= node; i++) {
                    if (graph[vertex][i] == 1 && check[i] == 0) {
                        check[i] = 1;
                        DFS(i, count);
                        check[i] = 0;
                    }
                }
            }
        }
    }
    static class Count {
        int count;
    }
}
