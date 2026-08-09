class Solution {
    public boolean possible(int arr[],int day,int m,int k)
    {
        int cnt=0;
        int totalBouquets=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<=day)
            {
                cnt++;
            }
            else
            {
                totalBouquets+=(cnt/k);
                cnt=0;
            }
        }
         totalBouquets+=(cnt/k);
        if(totalBouquets>=m) return true;
        else return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if(n<((long)m*k)) return -1;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++)
        {
            min=Math.min(min,bloomDay[i]);
            max=Math.max(max,bloomDay[i]);
        }
        int low=min;
        int high=max;
        int ans=0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(possible(bloomDay,mid,m,k)==true)
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