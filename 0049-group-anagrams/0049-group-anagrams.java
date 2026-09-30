class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         HashMap<String,List<String>> mpp = new HashMap<>();
         for(int i = 0;i<strs.length;i++)
         {
            String word = strs[i];
            char[] charArr = word.toCharArray();
            Arrays.sort(charArr);
            String key = String.valueOf(charArr);
            mpp.putIfAbsent(key,new ArrayList<>());
            mpp.get(key).add(word);
         }
         return new ArrayList<>(mpp.values());
    }
}