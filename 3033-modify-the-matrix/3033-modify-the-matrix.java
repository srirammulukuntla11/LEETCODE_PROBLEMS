class Solution {
    public static int findMaxValue(int[][] matrix,int col)
    {
        int max_value = Integer.MIN_VALUE;
        for(int i = 0;i<matrix.length;i++)
        {
            max_value = Math.max(max_value,matrix[i][col]);
        }
        return max_value;
    }
    public int[][] modifiedMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] result = new int[n][m];
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j < m;j++)
            {
                if(matrix[i][j] == -1)
                {
                    int max_value = findMaxValue(matrix,j);
                    result[i][j] = max_value;
                }
                else
                {
                    result[i][j] = matrix[i][j];
                }
            }
        }
        return result;
    }
}