class Solution {
    public void generateAns(ArrayList<String> ans,int n,int open,int close,String curr_str)
    {
        if(curr_str.length()==n*2)
        {
            ans.add(curr_str);
            return;
        }
        if(open<n)
        {
            generateAns(ans,n,open+1,close,curr_str+"(");

        } 
         if(close<open)
        {
            generateAns(ans,n,open,close+1,curr_str+")");

        } 
    }
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans=new ArrayList<>();
        generateAns(ans,n,0,0,"");  
        return ans;
    }
}