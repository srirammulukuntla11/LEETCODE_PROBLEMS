class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0;
        int right = 0;
        int max_len = 0;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        while(right < n)
        {
            mpp.put(fruits[right],mpp.getOrDefault(fruits[right],0)+1);
            while(mpp.size() > 2)
            {
                mpp.put(fruits[left],mpp.getOrDefault(fruits[left],0)-1);
                if(mpp.get(fruits[left]) == 0)
                {
                    mpp.remove(fruits[left]);
                }
                left++;
            }
            if(mpp.size() <= 2)
            {
                max_len = Math.max(max_len,right-left+1);
            }
            right++;

        }
        return max_len;
    }
}