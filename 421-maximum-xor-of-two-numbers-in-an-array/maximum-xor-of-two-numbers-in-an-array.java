class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    private TrieNode root = new TrieNode();

    public int findMaximumXOR(int[] nums) {

        for (int num : nums) {
            insert(num);
        }

        int maxXor = 0;

        for (int num : nums) {
            maxXor = Math.max(maxXor, getMaxXor(num));
        }

        return maxXor;
    }

    private void insert(int num) {

        TrieNode current = root;

        for (int i = 30; i >= 0; i--) {

            int bit = (num >> i) & 1;

            if (current.child[bit] == null) {
                current.child[bit] = new TrieNode();
            }

            current = current.child[bit];
        }
    }

    private int getMaxXor(int num) {

        TrieNode current = root;
        int result = 0;

        for (int i = 30; i >= 0; i--) {

            int bit = (num >> i) & 1;

            int opposite = 1 - bit;

            if (current.child[opposite] != null) {

                result |= (1 << i);
                current = current.child[opposite];

            } else {
                current = current.child[bit];
            }
        }

        return result;
    }
}