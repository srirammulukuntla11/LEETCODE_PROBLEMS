class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min_len = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        int right = 0;
        while(right < nums.length)
        {
            sum+=nums[right];
            while(sum >= target)
            {
                min_len = Math.min(min_len,right-left+1);
                sum-=nums[left];
                left++;
            }
            right++;
        }
         return min_len == Integer.MAX_VALUE ? 0 : min_len;
    }
}