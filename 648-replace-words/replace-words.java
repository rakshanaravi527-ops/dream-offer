import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isRoot;
    }

    private TrieNode root = new TrieNode();

    public String replaceWords(List<String> dictionary, String sentence) {

        // Build Trie from dictionary
        for (String word : dictionary) {
            insert(word);
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {

            String rootWord = findRoot(word);

            if (result.length() > 0) {
                result.append(" ");
            }

            result.append(rootWord);
        }

        return result.toString();
    }

    private void insert(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isRoot = true;
    }

    private String findRoot(String word) {

        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (current.children[index] == null) {
                return word;
            }

            current = current.children[index];

            if (current.isRoot) {
                return word.substring(0, i + 1);
            }
        }

        return word;
    }
}