class Solution {
    public void backtrack(List<List<Integer>> resultsets,List<Integer> tempset,int nums[],int start)
    {
        if(resultsets.contains((tempset)))
        {
            return;
        }
        resultsets.add(new ArrayList<>(tempset));
        for(int i=start;i<nums.length;i++)
        {
            tempset.add(nums[i]);
            backtrack(resultsets,tempset,nums,i+1);
            tempset.remove(tempset.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resultset=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(resultset,new ArrayList<>(),nums,0);
        return resultset;
    }
}
