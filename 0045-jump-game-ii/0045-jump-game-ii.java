class Solution {
    public int jump(int[] nums) {
         int n = nums.length;
       if(n == 1) return 0;
       int totalJumps = 0;
       int coverage = 0;
       int lastJumpInd = 0;
       int dest = n-1;
       for(int i=0;i<n;i++)
       {
           coverage = Math.max(coverage,i+nums[i]);
           if(i == lastJumpInd)
           {
               totalJumps+=1;
               lastJumpInd = coverage;
               if(coverage>=dest) return totalJumps;
           }
       }
       return totalJumps;
    }
    
}