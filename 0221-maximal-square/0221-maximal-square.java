class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int maxSide = 0;

        
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                maxSide = Math.max(maxSide, dp[i][0]);
            }
        }

     
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                maxSide = Math.max(maxSide, dp[0][j]);
            }
        }

        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
                
            }
        }

      
        return maxSide * maxSide;
    }
}
