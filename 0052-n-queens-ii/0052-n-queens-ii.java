class Solution {
    public static void nQueen(int col,int n,ArrayList<Integer> board,boolean[] rows,boolean[] diag1,boolean[] diag2,ArrayList<ArrayList<Integer>> res)
    {
        if(col > n)
        {
            res.add(new ArrayList<>(board));
            return;
        }
        for(int row = 1;row<=n;row++)
        {
            int d1 = row+col;
            int d2 = row-col+n;
            if(rows[row] || diag1[d1] || diag2[d2])
            {
                continue;
            }
            rows[row] = true;
            diag1[d1] = true;
            diag2[d2] = true;
            board.add(row);
            nQueen(col+1,n,board,rows,diag1,diag2,res);
            board.remove(board.size() - 1);
            rows[row] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
    public int totalNQueens(int n) {
         ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> board = new ArrayList<>();
        boolean rows[] = new boolean[n+1];
        boolean diag1[] = new boolean[2*n+1];
        boolean diag2[] = new boolean[2*n+1];
        nQueen(1,n,board,rows,diag1,diag2,res);
        return res.size();
    }
}