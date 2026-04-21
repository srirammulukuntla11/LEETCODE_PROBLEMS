class Solution {
     static int f(int ind1,int ind2,String s1,String s2,int[][] dp)
    {
        if(ind1<0 || ind2<0)
        {
            return 0;
            
            
        }
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(s1.charAt(ind1)==s2.charAt(ind2))
        {
            return dp[ind1][ind2] = 1+f(ind1-1,ind2-1,s1,s2,dp);
        }
        return  dp[ind1][ind2] = Math.max(f(ind1-1,ind2,s1,s2,dp),f(ind1,ind2-1,s1,s2,dp));
    }
    static int lcs(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();

    int dp[][] = new int[n + 1][m + 1];

    for (int ind1 = 1; ind1 <= n; ind1++) {
        for (int ind2 = 1; ind2 <= m; ind2++) {

            if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
            } else {
                dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }

        }
    }

    return dp[n][m];
}
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        return lcs(s,t);

    }
}