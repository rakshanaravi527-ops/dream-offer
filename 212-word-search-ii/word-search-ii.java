import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    private TrieNode root = new TrieNode();
    private List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        for (String word : words) {
            insert(word);
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root);
            }
        }

        return result;
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

        current.word = word;
    }

    private void dfs(char[][] board, int row, int col, TrieNode node) {

        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return;
        }

        char ch = board[row][col];

        if (ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }

        TrieNode next = node.children[ch - 'a'];

        if (next.word != null) {
            result.add(next.word);

            next.word = null;
        }

        board[row][col] = '#';

        dfs(board, row + 1, col, next);
        dfs(board, row - 1, col, next);
        dfs(board, row, col + 1, next);
        dfs(board, row, col - 1, next);

        board[row][col] = ch;
    }
}