class Solution {
    public boolean canJump(int[] nums) {
         int n = nums.length;
        int maxIndex = 0;
        int lastIndex = n - 1;
        for(int i=0;i<=n-1;i++)
        {
            if(i>maxIndex) return false;
            int currMax = i+nums[i];
            maxIndex = Math.max(maxIndex,currMax);
            if(maxIndex >= lastIndex) return true;
            
        }
        return true;
    }
}