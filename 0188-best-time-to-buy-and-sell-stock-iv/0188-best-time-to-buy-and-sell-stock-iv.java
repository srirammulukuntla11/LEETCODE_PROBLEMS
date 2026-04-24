class Solution {
        public int f(int ind,int buy,int cap,int[] prices,int[][][] dp)
    {
        if(cap == 0 || ind == prices.length) return 0;
        int profit = 0;
        if(dp[ind][buy][cap]!=-1) return dp[ind][buy][cap];
        if(buy == 1){
            return dp[ind][buy][cap] = Math.max(-prices[ind]+f(ind+1,0,cap,prices,dp),f(ind+1,1,cap,prices,dp));
            }
            else
            {
                return dp[ind][buy][cap] = Math.max(prices[ind]+f(ind+1,1,cap - 1,prices,dp),f(ind+1,0,cap,prices,dp));
            }
            // return profit;


        }
    public int maxProfit(int k, int[] prices) {
        int n =prices.length;
        int[][][] dp = new int[n][2][k+1];
        for(int i = 0;i<n;i++)
        {
            for(int j = 0 ;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return f(0,1,k,prices,dp);
    }
}