class Solution {
    public int maxEl(int arr[])
    {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            max=Math.max(max,arr[i]);
        }
        return max;
    }
    public int findTotalHours(int piles[],int hours)
    {
        int totalHours=0;
        for(int i=0;i<piles.length;i++)
        {
            totalHours+=Math.ceil((double)piles[i]/(double)hours);
        }
        return totalHours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=maxEl(piles);
        int ans=0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int totalHours=findTotalHours(piles,mid);
            if(totalHours<=h)
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
}