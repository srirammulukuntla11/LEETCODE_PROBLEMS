class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       Arrays.sort(nums);
       int n = nums.length;
       int target = 0;
       Set<List<Integer>> ans = new HashSet<>();
       for(int i = 0;i<n;i++)
       {
            int left = i + 1;
            int right = n - 1;
            while(left < right)
            {
                int sum = nums[i]+nums[left]+nums[right];
                if(sum == target)
                {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    ans.add(temp);
                    left++;
                    right--;
                }
                else if (sum < target) left++;
                else right--;
            }
       }
       return new ArrayList<>(ans);
    }
}