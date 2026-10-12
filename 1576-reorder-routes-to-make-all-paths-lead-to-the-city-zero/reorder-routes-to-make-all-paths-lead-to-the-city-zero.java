
import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : connections) {
            int a = edge[0];
            int b = edge[1];

            // Original direction: a -> b
            graph.get(a).add(new int[]{b, 1});

            // Reverse traversal edge: b -> a
            graph.get(b).add(new int[]{a, 0});
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int city, List<List<int[]>> graph,
                    boolean[] visited) {
        visited[city] = true;
        int changes = 0;

        for (int[] edge : graph.get(city)) {
            int neighbor = edge[0];
            int direction = edge[1];

            if (!visited[neighbor]) {
                changes += direction;
                changes += dfs(neighbor, graph, visited);
            }
        }

        return changes;
    }
}
