class Solution {
    public boolean canPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for(int i = 0;i<n;i++)
        {
            sum+=arr[i];
        }
        if(sum%2 != 0) return false;
        int target = sum/2;
        boolean dp[] = new boolean[target+1];
        dp[0] = true;
        for(int i = 0;i<n;i++)
        {
            for(int j = target;j>=arr[i];j--)
            {
                dp[j] = dp[j] || dp[j-arr[i]];
            }
            
        }
        return dp[target];
    }
}