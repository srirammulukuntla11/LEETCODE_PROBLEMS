class Solution {
    public String frequencySort(String s) {

        // Step 1: Count frequency of each character
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Convert map to list
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

        // Step 3: Sort by frequency in descending order
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

        // Step 4: Build the answer
        StringBuilder ans = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : list) {
            char ch = entry.getKey();
            int freq = entry.getValue();

            while (freq-- > 0) {
                ans.append(ch);
            }
        }

        return ans.toString();
}
}
