class Solution {
    public String longestCommonPrefix(String[] strs) {
            StringBuilder ans=new StringBuilder();
            Arrays.sort(strs);
            String first=strs[0];
            String second=strs[strs.length-1];
            for(int i=0;i<Math.min(first.length(),second.length());i++){
                if(first.charAt(i)!=second.charAt(i)){
                    break;
                }
                ans.append(first.charAt(i));
            }
            return ans.toString();

    }
}