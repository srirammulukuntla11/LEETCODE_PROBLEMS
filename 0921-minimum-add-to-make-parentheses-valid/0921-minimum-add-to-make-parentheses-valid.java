class Solution {
    public int minAddToMakeValid(String s) {
        int n=s.length();
        int openingCount=0;
        int closingCount=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='(') openingCount++;
            else if (s.charAt(i)==')' && openingCount>0) openingCount--;
            else closingCount++; 
        }
        return openingCount+closingCount;
    }
}