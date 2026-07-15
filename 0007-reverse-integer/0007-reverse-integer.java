class Solution {
    public int reverse(int n) {
        int revNo = 0;

        while (n != 0) {
            int ld = n % 10;

            // Check for overflow
            if (revNo > Integer.MAX_VALUE / 10 ||
               (revNo == Integer.MAX_VALUE / 10 && ld > 7))
                return 0;

            if (revNo < Integer.MIN_VALUE / 10 ||
               (revNo == Integer.MIN_VALUE / 10 && ld < -8))
                return 0;

            revNo = revNo * 10 + ld;
            n /= 10;
        }

        return revNo;
    }
}