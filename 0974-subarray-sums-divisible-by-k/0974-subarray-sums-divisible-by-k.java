class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int runningSum = 0;
        int cnt = 0;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        mpp.put(0,1);
        for(int i = 0;i<n;i++)
        {
            runningSum+=nums[i];
            int remainder = runningSum%k;
            if(remainder < 0)
            {
                remainder = remainder+k;
            }
            if(mpp.containsKey(remainder))
            {
                cnt+=mpp.get(remainder);
            }
            mpp.put(remainder,mpp.getOrDefault(remainder,0)+1);
        }
        return cnt;
    }
}