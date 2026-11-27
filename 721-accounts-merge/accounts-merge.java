
import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, Integer> emailToId = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        int n = accounts.size();
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Step 1: Map emails to account IDs
        for (int i = 0; i < n; i++) {

            String name = accounts.get(i).get(0);

            for (int j = 1; j < accounts.get(i).size(); j++) {

                String email = accounts.get(i).get(j);

                emailToId.put(email, i);
                emailToName.put(email, name);
            }
        }

        // Step 2: Union accounts having common emails
        for (int i = 0; i < n; i++) {

            for (int j = 2; j < accounts.get(i).size(); j++) {

                String email1 = accounts.get(i).get(1);
                String email2 = accounts.get(i).get(j);

                union(parent,
                      emailToId.get(email1),
                      emailToId.get(email2));
            }
        }

        // Step 3: Group emails by their parent account
        Map<Integer, List<String>> merged = new HashMap<>();

        for (String email : emailToId.keySet()) {

            int root = find(parent, emailToId.get(email));

            merged.putIfAbsent(root, new ArrayList<>());
            merged.get(root).add(email);
        }

        // Step 4: Sort emails and create final result
        List<List<String>> result = new ArrayList<>();

        for (int id : merged.keySet()) {

            List<String> emails = merged.get(id);
            Collections.sort(emails);

            List<String> account = new ArrayList<>();

            account.add(accounts.get(id).get(0));
            account.addAll(emails);

            result.add(account);
        }

        return result;
    }

    // Find operation
    private int find(int[] parent, int x) {

        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }

        return parent[x];
    }

    // Union operation
    private void union(int[] parent, int a, int b) {

        int rootA = find(parent, a);
        int rootB = find(parent, b);

        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
    }
}
