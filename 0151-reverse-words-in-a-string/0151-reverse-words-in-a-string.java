class Solution {
    public String reverseWords(String s) {
        StringBuilder res=new StringBuilder();
        String words[]=s.split(" +");
        for(int i=words.length-1;i>=0;i--){
            res.append(words[i]);
            res.append(" ");
        }
        return res.toString().trim();
    }
}