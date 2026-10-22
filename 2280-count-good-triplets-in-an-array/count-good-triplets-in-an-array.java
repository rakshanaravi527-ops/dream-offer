
class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            pos[nums2[i]] = i;
        }

        FenwickTree bit = new FenwickTree(n);
        long result = 0;

        for (int i = 0; i < n; i++) {
            int p = pos[nums1[i]];

            long left = bit.query(p);
            long right = (n - 1L - p) - (i - left);

            result += left * right;
            bit.update(p + 1);
        }

        return result;
    }

    static class FenwickTree {
        int[] tree;
        int n;

        FenwickTree(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void update(int index) {
            while (index <= n) {
                tree[index]++;
                index += index & -index;
            }
        }

        int query(int index) {
            int sum = 0;

            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }

            return sum;
        }
    }
}
