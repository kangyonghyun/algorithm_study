package basic.recursive;

import java.util.*;

public class AdjacencyMapDFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        int edge = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < edge; i++) {
            int to = sc.nextInt();
            int from = sc.nextInt();
            map.put(to, from);
        }
        AdjacencyMap dfs = new AdjacencyMap(node, map);
        System.out.println(dfs.getResultDFS());
    }

    static class AdjacencyMap {
        int node;
        Map<Integer, Integer> map;
        int[] check;

        public AdjacencyMap(int node, Map<Integer, Integer> map) {
            this.node = node;
            this.map = map;
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
                for (int i = 1; i < node; i++) {
                    int node = map.get(i);
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
