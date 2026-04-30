class Solution {
    public int calculate(char c) {
        if (c == 'I') return 1;
        else if (c == 'V') return 5;
        else if (c == 'X') return 10;
        else if (c == 'L') return 50;
        else if (c == 'C') return 100;
        else if (c == 'D') return 500;
        else if (c == 'M') return 1000;
        return 0;
    }

    public int romanToInt(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int v1 = calculate(s.charAt(i));
            int v2 = 0; // ✅ reset every iteration

            if (i + 1 < s.length()) {
                v2 = calculate(s.charAt(i + 1));
            }

            if (v1 < v2) {
                ans -= v1;
            } else {
                ans += v1;
            }
        }
        return ans;
    }
}
