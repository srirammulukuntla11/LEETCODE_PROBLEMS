class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        boolean found = false;
        HashMap<Integer,Integer> mpp = new HashMap<>(); // remainder,index
        int preSum = 0;
        mpp.put(0,-1);
        for(int i = 0;i<n;i++)
        {
            preSum += nums[i];
            int remainder = preSum%k;
            if(mpp.containsKey(remainder))
            {
                if(i- mpp.get(remainder) >=2 ){
                    found =  true;
                    break;
                    }
            }
            else{
                mpp.put(remainder,i);
            }

        }
        return found;

    }
}