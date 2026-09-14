class Solution {
    public static int CountPalindromes(String s,int left,int right)
    {
        int cnt = 0;
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            cnt++;
            left--;
            right++;

        }
        return cnt;
    }
    public int countSubstrings(String s) {
        int cnt = 0;
        for(int i = 0;i<s.length();i++)
        {
            cnt+=CountPalindromes(s,i,i);
            cnt+=CountPalindromes(s,i,i+1);
        }
        return cnt;
    }
}