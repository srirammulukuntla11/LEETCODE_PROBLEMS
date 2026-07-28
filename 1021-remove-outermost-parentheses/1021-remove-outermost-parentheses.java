class Solution {
    public String removeOuterParentheses(String s) {
     int n = s.length();
         StringBuilder res = new StringBuilder();
         int depth = 0;
         for(char ch : s.toCharArray())
         {
             if(ch == '(')
             {
                 depth++;
                 if(depth > 1) res.append(ch);
                 
             }
             else
             {
                 depth--;
                 if(depth > 0) res.append(ch);
             }
         }
         return res.toString();
    }
    }