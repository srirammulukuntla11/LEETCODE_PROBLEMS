class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 🚫 Start blocked
        if(grid[0][0] == 1) return 0;

        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                // 🚫 Obstacle
                if(grid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                // ✅ Start cell
                if(i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int up = (i > 0) ? dp[i - 1][j] : 0;
                    int left = (j > 0) ? dp[i][j - 1] : 0;

                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}