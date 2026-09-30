class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
        {
            return false;
        }
        // for(int i = 0;i<s.length();i++)
        // {
        //     int previousS = s.indexOf(s.charAt(i));
        //     int previousT = t.indexOf(t.charAt(i));
        //     if(previousS != previousT)
        //     {
        //         return false;
        //     }
        // }
        // return true;
        // HashMap<Character,Character> ST = new HashMap<>();
        // HashMap<Character,Character> TS = new HashMap<>();
        // for(int i = 0;i<s.length();i++)
        // {
        //     char a = s.charAt(i);
        //     char b = t.charAt(i);
        //     if(ST.containsKey(a) && ST.get(a) != b)
        //     {
        //         return false;
        //     }
        //     if(TS.containsKey(b) && TS.get(b) != a)
        //     {
        //         return false;
        //     }
        //     ST.put(a,b);
        //     TS.put(b,a);
        // }
        // return true;



         int[] mapST = new int[256];
         int[] mapTS = new int[256];
         Arrays.fill(mapST,-1);
         Arrays.fill(mapTS,-1);
         for(int i = 0;i<s.length();i++)
         {
            int a = s.charAt(i);
            int b = t.charAt(i);
            if(mapST[a] != -1 && mapST[a] != b)
            {
                return false;
            }
            if(mapTS[b] != -1 && mapTS[b] != a)
            {
                return false;
            }
            mapST[a] = b;
            mapTS[b] = a;
         }
         return true;





    }
}