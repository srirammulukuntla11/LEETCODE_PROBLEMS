class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];
        int[] suffSum = new int[n];
        int pSum = 0;
        int sSum = 0;
        for(int i = 0;i<n;i++)
        {
            pSum+=nums[i];
            preSum[i] = pSum;
            sSum+=nums[n-i-1];
            suffSum[n-i-1] = sSum;
        }
        for(int i = 0;i<n;i++)
        {
            if((i == 0 ? 0 : preSum[i-1]) == (i == n-1 ? 0 : suffSum[i+1]))
            {
                return i;
            }
        }
        return -1;
    }
}