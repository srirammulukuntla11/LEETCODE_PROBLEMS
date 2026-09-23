class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // StringBuilder sb = new StringBuilder(magazine);
        // for(char c : ransomNote.toCharArray())
        // {
        //     int index = sb.indexOf(String.valueOf(c));
        //     if(index == -1)
        //     {
        //         return false;
        //     }
        //     sb.deleteCharAt(index);

        // }
        // return true;
        HashMap<Character,Integer> mpp = new HashMap<>();
        for(char c : magazine.toCharArray())
        {
            mpp.put(c,mpp.getOrDefault(c,0)+1);
        }
        for(char ch : ransomNote.toCharArray())
        {
            if(!mpp.containsKey(ch) || mpp.get(ch) <= 0)
            {
                return false;
            }
            
            mpp.put(ch,mpp.get(ch)-1);
        }
        return true;









    }
}