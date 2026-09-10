class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int cnt = 0;
        int product = 1;
        int left = 0;
        int right = 0;
        if (k <= 1) return 0;
        while(right < nums.length)
        {
            product = product * nums[right];
            while(product >= k)
            {
                product = product/nums[left];
                left++;
            }
            if(product < k)
            {
                cnt+=(right - left + 1);
            }
            right++;
        }
        return cnt;
    }
}