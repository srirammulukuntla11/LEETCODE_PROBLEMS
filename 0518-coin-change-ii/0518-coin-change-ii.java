class Solution {
    public int f(int ind,int T,int coins[],int[][] dp)
    {
        if(ind==0){
            if(T%coins[0]==0) return 1;
            else return 0;
        }
        if(dp[ind][T]!=-1) return dp[ind][T];
        int notTake=f(ind-1,T,coins,dp);
        int take=0;
        if(coins[ind]<=T) take=f(ind,T-coins[ind],coins,dp);
       return dp[ind][T]=take+notTake;
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return f(n-1,amount,coins,dp);
    }
}