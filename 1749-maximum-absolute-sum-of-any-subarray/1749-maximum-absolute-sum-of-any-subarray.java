class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
           int maxSubArrSum1 = Integer.MIN_VALUE;
           int maxSubArrSum2 = Integer.MIN_VALUE;
           int sum1 = 0;
           int sum2 = 0;
           for(int i = 0;i<n;i++)
           {
                sum1+=nums[i];
                maxSubArrSum1 = Math.max(maxSubArrSum1,sum1);
                if(sum1 < 0)
                {
                    sum1 = 0;
                }
                sum2 = sum2+(nums[i]*-1);
                maxSubArrSum2 = Math.max(maxSubArrSum2,sum2);
                if(sum2 < 0)
                {
                    sum2 = 0;
                }
                
           }
           return Math.max(maxSubArrSum1,maxSubArrSum2);
    }
}