class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int maxCon = 0;
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i] == 1)
            {
                cnt++;
                maxCon = Math.max(maxCon,cnt);
            }
            else
            {
                cnt = 0;
            }
        }
        return maxCon;
    
    }
}