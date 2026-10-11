import java.util.*;

class MapSum {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int sum = 0;
    }

    private TrieNode root;
    private HashMap<String, Integer> map;

    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int oldValue = map.getOrDefault(key, 0);
        int diff = val - oldValue;

        map.put(key, val);

        TrieNode node = root;

        for (char c : key.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
            node.sum += diff;
        }
    }

    public int sum(String prefix) {
        TrieNode node = root;

        for (char c : prefix.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                return 0;
            }

            node = node.children[index];
        }

        return node.sum;
    }
}