class Solution {
    public int trap(int[] height) {
              int n = height.length;
              int res = 0;
              int left = 1;
              int right = n-2;
              int lmax = height[left - 1];
              int rmax = height[right + 1];
              
              while(left<=right)
              {
                if(rmax<=lmax)
                {
                    int water = rmax - height[right];
                     if(water>0)
                          res=res+water;
                    rmax=Math.max(rmax,height[right]);
                    right=right-1;
                }
                
                else
                {
                    int water = lmax - height[left];
                    if(water>0) res = res + water;
                    lmax=Math.max(lmax,height[left]);
                    left = left + 1;
                }
                
              }
              return res;

       
    }
}