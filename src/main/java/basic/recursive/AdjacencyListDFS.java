package basic.recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjacencyListDFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        int edge = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= edge; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edge; i++) {
            int to = sc.nextInt();
            int from = sc.nextInt();
            list.get(to).add(from);
        }
        AdjacencyList dfs = new AdjacencyList(node, list);
        System.out.println(dfs.getResultDFS());
    }

    static class AdjacencyList {
        int node;
        List<List<Integer>> list;
        int[] check;

        public AdjacencyList(int node, List<List<Integer>> list) {
            this.node = node;
            this.list = list;
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
                for (int node : list.get(vertex)) {
                    if (check[node] == 0) {
                        check[node] = 1;
                        DFS(node, count);
                        check[node] = 0;
                    }
                }
            }
        }
    }
    static class Count {
        int count;
    }
}
