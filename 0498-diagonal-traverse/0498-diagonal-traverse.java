class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m*n];
        int row = 0;
        int col = 0;
        boolean up = true;
        for(int i = 0;i < m*n;i++)
        {
            result[i] = mat[row][col];
        
        if(up)
        {
            // move up
            if(col == n-1)
            {
                row++;
                up = false;
            }
            else if (row == 0)
            {
                col++;
                up = false;
            }
            else
            {
                row--;
                col++;
            }
        }
        else
        {
            //downward
            if(row == m - 1)
            {
                col++;
                up = true;
            }
            else if(col == 0)
            {
                row++;
                up = true;
            }
            else
            {
                row++;
                col--;

            }
        }
        }
        return result;


    }
}