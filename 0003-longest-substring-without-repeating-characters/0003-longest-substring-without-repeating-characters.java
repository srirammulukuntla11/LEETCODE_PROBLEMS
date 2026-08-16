import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> mpp = new HashMap<>();

        int l = 0;
        int r = 0;
        int n = s.length();
        int maxlen = 0;

        while(r < n)
        {
            if(mpp.containsKey(s.charAt(r)))
            {
                if(mpp.get(s.charAt(r)) >= l)
                {
                    l = mpp.get(s.charAt(r)) + 1;
                }
            }

            int len = r - l + 1;
            maxlen = Math.max(len, maxlen);

            mpp.put(s.charAt(r), r);
            r++;
        }

        return maxlen;
    }
}