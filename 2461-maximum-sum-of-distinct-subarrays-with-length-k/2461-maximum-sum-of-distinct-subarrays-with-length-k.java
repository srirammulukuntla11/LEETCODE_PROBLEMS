import java.util.HashSet;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();

        long max_sum = 0;
        long sum = 0;

        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            set.add(nums[right]);
            sum += nums[right];

            int len = right - left + 1;

            if (len == k) {

                max_sum = Math.max(max_sum, sum);

                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
        }

        return max_sum;
    }
}