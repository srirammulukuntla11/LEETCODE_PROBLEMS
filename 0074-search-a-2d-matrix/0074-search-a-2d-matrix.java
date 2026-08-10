class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;//row_size
        int m=matrix[0].length;//col_size;
        int low=0;
        int high=(n*m)-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(matrix[mid/m][mid%m]==target) return true;
            else if(target>matrix[mid/m][mid%m])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            
            }
        }
        return false;

    }
}