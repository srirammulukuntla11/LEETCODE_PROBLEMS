class Solution {
      public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int dp[][] = new int[n][target + 1];

        // Base case
        if (nums[0] == 0) dp[0][0] = 2;  // pick or not pick
        else dp[0][0] = 1;

        if (nums[0] != 0 && nums[0] <= target)
            dp[0][nums[0]] = 1;

        for (int ind = 1; ind < n; ind++) {
            for (int tar = 0; tar <= target; tar++) {

                int notTake = dp[ind - 1][tar];

                int take = 0;
                if (nums[ind] <= tar) {
                    take = dp[ind - 1][tar - nums[ind]];
                }

                dp[ind][tar] = take + notTake;
            }
        }

        return dp[n - 1][target];
    }
    public int countPartitions(int[] arr, int diff) {
        int totalSum=0;
        for(int i:arr){
            totalSum+=i;
        }
        if(totalSum-diff<0 || (totalSum-diff)%2!=0) return 0;
        return perfectSum(arr,(totalSum-diff)/2);
        
        
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        return countPartitions(nums,target);
    }
}