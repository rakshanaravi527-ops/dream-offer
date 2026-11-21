import java.util.*;

class Solution {

    int[] answer;
    ArrayList<Integer>[] children;

    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        answer = new int[n];

        // Create original tree
        ArrayList<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        // Store new parents
        int[] newParent = parent.clone();

        int[] last = new int[26];
        Arrays.fill(last, -1);

        // Find new parents using DFS
        dfs1(0, tree, s, last, newParent);

        // Create modified tree
        children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            children[newParent[i]].add(i);
        }

        // Calculate subtree sizes
        dfs2(0);

        return answer;
    }

    // DFS to find new parents
    void dfs1(int node, ArrayList<Integer>[] tree,
              String s, int[] last, int[] newParent) {

        int ch = s.charAt(node) - 'a';

        int previous = last[ch];

        if (node != 0 && previous != -1) {
            newParent[node] = previous;
        }

        last[ch] = node;

        for (int child : tree[node]) {
            dfs1(child, tree, s, last, newParent);
        }

        last[ch] = previous;
    }

    // DFS to calculate subtree sizes
    int dfs2(int node) {

        int size = 1;

        for (int child : children[node]) {
            size += dfs2(child);
        }

        answer[node] = size;

        return size;
    }
}