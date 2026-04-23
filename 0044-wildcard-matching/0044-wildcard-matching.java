import java.util.Arrays;

class Solution {
    public int f(int i, int j, String s, String p, int[][] dp) {
        if (i < 0 && j < 0) return 1;
        if (j < 0 && i >= 0) return 0;

        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') return 0;
            }
            return 1;
        }

        if (dp[i][j] != -1) return dp[i][j];

        // match or '?'
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return dp[i][j] = f(i - 1, j - 1, s, p, dp);
        }

        // '*' case
        if (p.charAt(j) == '*') {
            int ans = (f(i - 1, j, s, p, dp) == 1 || 
                       f(i, j - 1, s, p, dp) == 1) ? 1 : 0;
            return dp[i][j] = ans;
        }

        return dp[i][j] = 0;
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return f(n - 1, m - 1, s, p, dp) == 1;
    }
}