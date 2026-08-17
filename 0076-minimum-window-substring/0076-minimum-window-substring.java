class Solution {
    public String minWindow(String s, String t) {

        int n = s.length();
        int m = t.length();

        HashMap<Character,Integer> map = new HashMap<>();

        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        int l = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        for(int r = 0; r < n; r++) {

            char c = s.charAt(r);

            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);

                if(map.get(c) >= 0)
                    count++;
            }

            while(count == m) {

                if(r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    startIndex = l;
                }

                char left = s.charAt(l);

                if(map.containsKey(left)) {
                    map.put(left, map.get(left) + 1);

                    if(map.get(left) > 0)
                        count--;
                }

                l++;
            }
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }
}