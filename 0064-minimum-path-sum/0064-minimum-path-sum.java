class Solution {
    public int minPathSum(int[][] grid) {
    //   int n = grid.length;
    //   int m = grid[0].length;
    //   int[][] dp = new int[n][m];
    //   int sum = 0;
    //   sum+=grid[0][0];
    //   for(int i = 0;i<n;i++)
    //   {
    //     for(int j = 0;j<m;j++){
    //         if(j < m && i < n){
    //         int right = grid[i][j+1]; 
    //         int down = grid[i+1][j];
    //         sum+=Math.min(right,down);
    //         }
    //     }
    //   }
    //   return sum;
      int m = grid.length; //rows 
      int n = grid[0].length;//cols
      int[] dp = new int[n];
      dp[0] = grid[0][0];
      for(int j = 1;j<n;j++)
      {
        dp[j] = dp[j-1] + grid[0][j];
      }
      for(int i = 1;i<m;i++)
      {
        dp[0] = dp[0] + grid[i][0];
        for(int j = 1;j<n;j++)
        {
            dp[j] = grid[i][j]+ Math.min(dp[j],dp[j-1]);
        }
      }
      return dp[n-1];


    }
}