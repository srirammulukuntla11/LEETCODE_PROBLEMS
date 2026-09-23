class Solution {
    public boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        // char[] str1 = s1.toCharArray();
        // char[] str2 = s2.toCharArray();
        // Arrays.sort(str1);
        // Arrays.sort(str2);
        // return Arrays.equals(str1,str2);


        HashMap<Character,Integer> mpp = new HashMap<>();
        for(char c : s1.toCharArray())
        {
            mpp.put(c,mpp.getOrDefault(c,0)+1);
        }
        for(char ch : s2.toCharArray())
        {
            if(!mpp.containsKey(ch))
            {
                return false;
            }
            mpp.put(ch,mpp.get(ch)-1);
            if(mpp.get(ch) < 0)
            {
                return false;
            }
        }
        return true;




        
    }
      
}