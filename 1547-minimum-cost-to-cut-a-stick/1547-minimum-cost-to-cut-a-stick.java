import java.util.*;

class Solution {

    public int f(int i, int j, List<Integer> cuts, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int mini = Integer.MAX_VALUE;

        for (int ind = i; ind <= j; ind++) {
            int cost = cuts.get(j + 1) - cuts.get(i - 1)
                    + f(i, ind - 1, cuts, dp)
                    + f(ind + 1, j, cuts, dp);

            mini = Math.min(mini, cost);
        }

        return dp[i][j] = mini;
    }

    public int minCost(int n, int[] cutsArr) {

        List<Integer> cuts = new ArrayList<>();

        for (int x : cutsArr) cuts.add(x);

        // add boundaries
        cuts.add(0);
        cuts.add(n);

        Collections.sort(cuts);

        int c = cutsArr.length;

        int[][] dp = new int[c + 1][c + 1];

        for (int[] row : dp) Arrays.fill(row, -1);

        return f(1, c, cuts, dp);
    }
}