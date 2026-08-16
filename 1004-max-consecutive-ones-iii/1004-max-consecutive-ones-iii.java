class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0;
        int r=0;
        int n=nums.length;
        int maxlen=0;
        int zeros=0;

        while(r<n)
        {
            if(nums[r]==0){
                zeros++;
            }

            while(zeros>k)
            {
                if(nums[l]==0)
                {
                    zeros--;
                }
                l++;
            }

            int len=r-l+1;
            maxlen=Math.max(maxlen,len);

            r++;
        }
        return maxlen;
    }
}