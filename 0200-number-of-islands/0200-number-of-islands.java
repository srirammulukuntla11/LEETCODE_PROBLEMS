class Solution {
    public void dfs(char[][] grid,int i,int j)
    {
        int rows = grid.length;
        int cols = grid[0].length;
        if(i<0 || i>= rows || j<0 || j>=cols)
        {
            return;
        }
        if(grid[i][j] == '0')
        {
            return;
        }
        grid[i][j] = '0';
        dfs(grid,i-1,j); // top
        dfs(grid,i+1,j); // down
        dfs(grid,i,j-1); // left;
        dfs(grid,i,j+1); // right;
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int cnt = 0;
        for(int i = 0;i<rows;i++)
        {
            for(int j = 0;j<cols;j++)
            {
                if(grid[i][j] == '1')
                {
                    cnt++;
                    dfs(grid,i,j);
                }
            }
        }
        return cnt;
    }
}