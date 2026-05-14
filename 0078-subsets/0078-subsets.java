class Solution {
    public void backtrack(List<List<Integer>> resultsets,List<Integer> tempset,int nums[],int start)
    {
        resultsets.add(new ArrayList<>(tempset));
        for(int i=start;i<nums.length;i++)
        {
            tempset.add(nums[i]);
            backtrack(resultsets,tempset,nums,i+1);
            tempset.remove(tempset.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultset=new ArrayList<>();
        backtrack(resultset,new ArrayList<>(),nums,0);
        return resultset;
    }
}