class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> hashSet = new HashSet<>();
        for(int i = 0;i<9;i++)
        {
            for(int j = 0;j<9;j++)
            {
                char num = board[i][j];
                if(num != '.'){
                     if(hashSet.contains(num+"_R_"+i) || 
                     hashSet.contains(num+"_C_"+j) ||
                     hashSet.contains(num+"_B_"+i/3+"_"+j/3)) 
                     {
                        return false;
                     }
                     else
                     {
                        hashSet.add(num+"_R_"+i);
                        hashSet.add(num+"_C_"+j);
                        hashSet.add(num+"_B_"+i/3+"_"+j/3);
                     }
                }
               
            }
        }
        return true;
    }
}