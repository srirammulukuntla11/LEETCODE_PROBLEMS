class Solution {
    public int findTotalDays(int arr[],int mid)
    {
        int day=1,load=0;
        for(int i=0;i<arr.length;i++)
        {
            if(load+arr[i]>mid)
            {
                day=day+1;
                load=arr[i];
            }
            else
            {
                load+=arr[i];
            }
        }
        return day;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low=Arrays.stream(weights).max().getAsInt();
        int high=Arrays.stream(weights).sum();
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int totalDays=findTotalDays(weights,mid);
            if(totalDays<=days)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }
}