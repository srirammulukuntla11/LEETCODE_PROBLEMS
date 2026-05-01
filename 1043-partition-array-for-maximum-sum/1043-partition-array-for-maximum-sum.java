class Solution {
    public  int f(int ind,int arr[],int k,int[] dp)
    {
        if(ind == arr.length) return 0;
        int len = 0;
        if(dp[ind]!=-1) return dp[ind];
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        for(int i = ind;i<Math.min(arr.length,ind+k);i++)
        {
            len++;
            maxi = Math.max(maxi,arr[i]);
            int sum = (len*maxi)+f(i+1,arr,k,dp);
            maxAns = Math.max(sum,maxAns);
        }
        return dp[ind] = maxAns;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        for(int i = 0;i<n;i++)
        {
            Arrays.fill(dp,-1);
        }
        return f(0,arr,k,dp);
    }
}