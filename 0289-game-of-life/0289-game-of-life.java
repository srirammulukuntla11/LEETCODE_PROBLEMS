class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        // Directions array to easily navigate 8 neighbors
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            { 0, -1},          { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1}
        };
        
        // Step 1: Track state changes using temporary values
        //  1 -> 0 (Live to Dead) : Represented by -1
        //  0 -> 1 (Dead to Live) : Represented by 2
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = 0;
                
                // Count live neighbors
                for (int[] dir : directions) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    
                    // Check boundaries
                    if (ni >= 0 && ni < rows && nj >= 0 && nj < cols) {
                        // If cell was originally 1 (currently 1 or -1), count it
                        if (board[ni][nj] == 1 || board[ni][nj] == -1) {
                            liveNeighbors++;
                        }
                    }
                }
                
                // Apply Game of Life rules
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = -1; // Flagged to die
                    }
                } else if (board[i][j] == 0) {
                    if (liveNeighbors == 3) {
                        board[i][j] = 2; // Flagged to revive
                    }
                }
            }
        }
        
        // Step 2: Finalize the state transitions
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
