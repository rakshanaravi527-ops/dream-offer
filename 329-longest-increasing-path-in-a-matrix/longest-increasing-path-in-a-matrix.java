
class Solution {
    private int[][] dp;
    private int[][] matrix;

    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, -1, 1};

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;

        int m = matrix.length;
        int n = matrix[0].length;

        dp = new int[m][n];
        int longest = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                longest = Math.max(longest, dfs(i, j));
            }
        }

        return longest;
    }

    private int dfs(int r, int c) {
        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        dp[r][c] = 1;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < matrix.length &&
                nc >= 0 && nc < matrix[0].length &&
                matrix[nr][nc] > matrix[r][c]) {

                dp[r][c] = Math.max(
                    dp[r][c],
                    1 + dfs(nr, nc)
                );
            }
        }

        return dp[r][c];
    }
}
