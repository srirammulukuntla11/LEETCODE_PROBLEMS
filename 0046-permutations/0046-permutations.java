class Solution {
    // public static void backtrack(
    //     int nums[],
    //     boolean[] used,
    //     ArrayList<Integer> curr,
    //     List<List<Integer>> result)
    //     {
    //         if(curr.size() == nums.length)
    //         {
    //             result.add(new ArrayList<>(curr));
    //             return;
    //         }
    //         for(int i = 0;i<nums.length;i++)
    //         {
    //             if(used[i] == true)
    //             {
    //                 continue;
    //             }
    //             used[i] = true;
    //             curr.add(nums[i]);
    //             backtrack(nums,used,curr,result);
    //             curr.remove(curr.size() - 1);
    //             used[i] = false;
    //         }

    //     }

    
    public static void backtrack(int[] nums,int index,List<List<Integer>> result)
    {
        if(index == nums.length)
        {
            List<Integer> temp = new ArrayList<>();
            for(int num : nums)
            {
                temp.add(num);
            }
            result.add(temp);
            return;
        }
        for(int i = index;i<nums.length;i++)
        {
            swap(nums,index,i);
            backtrack(nums,index+1,result);
            swap(nums,index,i);
        }
    }
    public static void swap(int[] nums,int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // boolean used[] = new boolean[nums.length];
        // ArrayList<Integer> curr = new ArrayList<>();
        // backtrack(nums,used,curr,result);
        // return result;
        backtrack(nums,0,result);
        return result;

    }
}