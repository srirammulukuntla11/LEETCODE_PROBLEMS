class Solution {
    public boolean checkInclusion(String p, String s) {
        boolean found = false;
         int[] pCount = new int[26];
        int[] sCount = new int[26];
        
        for(int i = 0;i<p.length();i++)
        {
            pCount[p.charAt(i) - 'a']++;
        }
        for(int i = 0;i<s.length();i++)
        {
            sCount[s.charAt(i) - 'a']++;
            if(i >= p.length())
            {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }
            if(Arrays.equals(sCount,pCount))
            {
                found = true;
                break;
            }
        }
        return found;
    }
}