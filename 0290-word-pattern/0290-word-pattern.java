class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[] = s.split(" ");
        if(pattern.length() != words.length) 
               return false;
        HashMap<Character,String> CharToWord = new HashMap<>();
        HashMap<String,Character> WordToChar = new HashMap<>();
        int index = 0;
        for(int i = 0;i<pattern.length();i++)
        {

            char c = pattern.charAt(i);
            String word = words[i];
            if(CharToWord.containsKey(c) && !CharToWord.get(c).equals(word))
            {
                return false;
            }
            if(WordToChar.containsKey(word) && WordToChar.get(word) != c)
            {
                return false;
            }
            CharToWord.put(c,word);
            WordToChar.put(word,c);
        }
        return true;
    }
}