class Solution {
    public int numberOfSubarrays2(int[] nums, int k) {
             int l=0;
        int r=0;
        int n=nums.length;
        int sum=0;
        int cnt=0;
        if(k<0) return 0;
        while(r<n)
        {
            sum+=nums[r]%2;
            while(sum>k)
            {
                sum-=nums[l]%2;
                l++;
            }
            cnt+=r-l+1;
            r++;
        }
        return cnt;
        }
    public int numberOfSubarrays(int[] nums, int k) {
             int l=0;
        int r=0;
        int n=nums.length;
        int sum=0;
        int cnt=0;
        if(k<0) return 0;
        while(r<n)
        {
            sum+=nums[r]%2;
            while(sum>k)
            {
                sum-=nums[l]%2;
                l++;
            }
            cnt+=r-l+1;
            r++;
        }
        return cnt-numberOfSubarrays2(nums,k-1);
    }
}