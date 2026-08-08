class Solution {
    public static int lower_bound(int nums[],int n,int target)
    {
        int ans=n;
        int low=0;
        int high=n-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]>=target)
            {
                ans=mid;
                high=mid-1;   
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
     public static int upper_bound(int nums[],int n,int target)
    {
        int ans=n;
        int low=0;
        int high=n-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]>target)
            {
                ans=mid;
                high=mid-1;   
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
     int n=nums.length;
     int lb=lower_bound(nums,n,target);
     if(lb==n || nums[lb]!=target) return new int[]{-1,-1};
     return new int[]{lb,upper_bound(nums,n,target)-1};
    }
}