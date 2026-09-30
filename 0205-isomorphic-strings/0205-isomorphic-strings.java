class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
        {
            return false;
        }
        for(int i = 0;i<s.length();i++)
        {
            int previousS = s.indexOf(s.charAt(i));
            int previousT = t.indexOf(t.charAt(i));
            if(previousS != previousT)
            {
                return false;
            }
        }
        return true;

    }
}