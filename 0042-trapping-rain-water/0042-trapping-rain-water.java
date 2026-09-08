class Solution {
    public int trap(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int lmax = 0;
        int rmax = 0;
        int total = 0;
        while(left <= right)
        {
            if(arr[left] <= arr[right])
            {
                lmax = Math.max(lmax,arr[left]);
                total+=(lmax-arr[left]);
                left++;
                
            }
            else
            {
                rmax = Math.max(rmax,arr[right]);
                total+=(rmax-arr[right]);
                right--;
            }
        }
        return total;
    }

}