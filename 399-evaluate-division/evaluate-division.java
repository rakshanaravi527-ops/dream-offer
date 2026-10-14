
import java.util.*;

class Solution {
    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = new HashMap<>();

        // Build the weighted graph
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.computeIfAbsent(a, k -> new HashMap<>())
                 .put(b, value);

            graph.computeIfAbsent(b, k -> new HashMap<>())
                 .put(a, 1.0 / value);
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            result[i] = dfs(start, end, graph, new HashSet<>());
        }

        return result;
    }

    private double dfs(
            String current,
            String target,
            Map<String, Map<String, Double>> graph,
            Set<String> visited) {

        if (!graph.containsKey(current) ||
            !graph.containsKey(target)) {
            return -1.0;
        }

        if (current.equals(target)) {
            return 1.0;
        }

        visited.add(current);

        for (Map.Entry<String, Double> edge :
                graph.get(current).entrySet()) {

            String neighbor = edge.getKey();
            double weight = edge.getValue();

            if (!visited.contains(neighbor)) {
                double result = dfs(
                    neighbor, target, graph, visited
                );

                if (result != -1.0) {
                    return weight * result;
                }
            }
        }

        return -1.0;
    }
}
