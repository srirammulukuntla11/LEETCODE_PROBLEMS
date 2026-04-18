class Solution {
    public int f(int i, int j1, int j2, int n, int m, int[][] grid, int[][][] dp) {
        if (j1 < 0 || j2 < 0 || j1 >= m || j2 >= m) return (int)-1e8;

        if (i == n - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int max = (int)-1e8;

        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {

                int value;
                if (j1 == j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];

                value += f(i + 1, j1 + dj1, j2 + dj2, n, m, grid, dp);

                max = Math.max(max, value);
            }
        }

        return dp[i][j1][j2] = max;
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        // ✅ initialize with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return f(0, 0, m - 1, n, m, grid, dp);
    }
}