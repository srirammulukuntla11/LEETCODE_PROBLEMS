class Solution {

    // same as your do() but optimized
    public static int helper(int[] nums, int start, int end) {
        int prev = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {
            int take = nums[i];
            if (i > start) take += prev2;

            int notTake = prev;

            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public int rob(int[] nums) {
        int n = nums.length;

        // edge cases
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // case 1: skip first house
        int case1 = helper(nums, 1, n - 1);

        // case 2: skip last house
        int case2 = helper(nums, 0, n - 2);

        return Math.max(case1, case2);
    }
}