class Solution {
    public static void backtrack(
        int nums[],
        boolean[] used,
        ArrayList<Integer> curr,
        List<List<Integer>> result)
        {
            if(curr.size() == nums.length)
            {
                result.add(new ArrayList<>(curr));
                return;
            }
            for(int i = 0;i<nums.length;i++)
            {
                if(used[i] == true)
                {
                    continue;
                }
                used[i] = true;
                curr.add(nums[i]);
                backtrack(nums,used,curr,result);
                curr.remove(curr.size() - 1);
                used[i] = false;
            }

        }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean used[] = new boolean[nums.length];
        ArrayList<Integer> curr = new ArrayList<>();
        backtrack(nums,used,curr,result);
        return result;

    }
}