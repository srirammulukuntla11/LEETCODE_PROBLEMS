class Solution {
    public void backtrack(int index,int target,int[] arr,List<Integer> ds,List<List<Integer>> ans)
    {
        int n=arr.length;
        if(index==n)
        {
            if(target==0)
            {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[index]<=target)
        {
            ds.add(arr[index]);
            backtrack(index,target-arr[index],arr,ds,ans);
            ds.remove(ds.size()-1);
            
        }
        backtrack(index+1,target,arr,ds,ans);
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(0,target,candidates,new ArrayList<>(),ans);
        return ans;
    }
}