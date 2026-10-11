class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k--;

        while (k > 0) {
            long steps = countSteps(n, current, current + 1);

            if (steps <= k) {
                current++;
                k -= steps;
            } else {
                current *= 10;
                k--;
            }
        }

        return current;
    }

    private long countSteps(int n, long first, long next) {
        long steps = 0;

        while (first <= n) {
            steps += Math.min((long) n + 1, next) - first;
            first *= 10;
            next *= 10;
        }

        return steps;
    }
}