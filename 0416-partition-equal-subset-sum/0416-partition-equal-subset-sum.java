class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n][sum + 1];

        // Base case: sum = 0 is always possible
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Base case for first element
        if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }

        // DP logic
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= sum; target++) {

                boolean notTake = dp[ind - 1][target];

                boolean take = false;
                if (target >= arr[ind]) {
                    take = dp[ind - 1][target - arr[ind]];
                }

                dp[ind][target] = notTake || take;
            }
        }

        return dp[n - 1][sum];
    }

    public boolean canPartition(int[] nums) {
        int totSum = 0;

        for (int i : nums) {
            totSum += i;
        }

        // If total sum is odd → cannot partition
        if (totSum % 2 != 0) return false;

        int target = totSum / 2;

        return isSubsetSum(nums, target);
    }
}