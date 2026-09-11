class Solution {

    public int atMostK(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int l = 0;
        int count = 0;

        for(int r = 0; r < nums.length; r++) {

            map.put(nums[r], map.getOrDefault(nums[r],0) + 1);

            while(map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);

                if(map.get(nums[l]) == 0)
                    map.remove(nums[l]);

                l++;
            }

            count += r - l + 1;
        }

        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
}