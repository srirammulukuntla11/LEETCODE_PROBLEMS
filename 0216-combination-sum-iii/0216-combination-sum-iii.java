class Solution {

    public void backtrack(int index,int sum,int k,int n,List<Integer> ds,List<List<Integer>> ans)
    {
        if(sum==n && k==0)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }

        if(sum>n || k<0)
        {
            return;
        }

        for(int i=index;i<=9;i++)
        {
            ds.add(i);

            backtrack(i+1,sum+i,k-1,n,ds,ans);

            ds.remove(ds.size()-1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) 
    {
        List<List<Integer>> ans=new ArrayList<>();

        backtrack(1,0,k,n,new ArrayList<>(),ans);

        return ans;
    }
}