
import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();

        if (n == 1) {
            result.add(0);
            return result;
        }

        List<Set<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Queue<Integer> leaves = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.offer(i);
            }
        }

        int remaining = n;

        while (remaining > 2) {
            int size = leaves.size();
            remaining -= size;

            for (int i = 0; i < size; i++) {
                int leaf = leaves.poll();

                for (int neighbor : graph.get(leaf)) {
                    graph.get(neighbor).remove(leaf);

                    if (graph.get(neighbor).size() == 1) {
                        leaves.offer(neighbor);
                    }
                }
            }
        }

        result.addAll(leaves);
        return result;
    }
}
