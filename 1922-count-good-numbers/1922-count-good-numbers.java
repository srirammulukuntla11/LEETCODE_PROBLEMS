class Solution {

    long MOD = 1_000_000_007;

    public long binaryExponent(long a, long b) {
        long res = 1;

        while (b > 0) {

            if (b % 2 == 1) {
                res = (res * a) % MOD;
            }

            a = (a * a) % MOD;
            b = b / 2;
        }

        return res;
    }

    public int countGoodNumbers(long n) {

        long even = (n + 1) / 2;  
        long odd = n / 2;

        long ans = (binaryExponent(5, even) * binaryExponent(4, odd)) % MOD;

        return (int) ans;
    }
}