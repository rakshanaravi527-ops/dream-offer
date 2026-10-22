
class Solution {
    private static final int MOD = 1_000_000_007;

    public int createSortedArray(int[] instructions) {
        int max = 100000;
        int[] bit = new int[max + 1];
        long cost = 0;

        for (int i = 0; i < instructions.length; i++) {
            int x = instructions[i];

            int less = query(bit, x - 1);
            int lessOrEqual = query(bit, x);
            int greater = i - lessOrEqual;

            cost = (cost + Math.min(less, greater)) % MOD;

            update(bit, x, max);
        }

        return (int) cost;
    }

    private int query(int[] bit, int index) {
        int sum = 0;

        while (index > 0) {
            sum += bit[index];
            index -= index & -index;
        }

        return sum;
    }

    private void update(int[] bit, int index, int max) {
        while (index <= max) {
            bit[index]++;
            index += index & -index;
        }
    }
}
