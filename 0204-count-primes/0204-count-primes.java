class Solution {
    public static boolean prime(int n) {
    if (n <= 1) {
        return false;
    }

    int limit = (int) Math.sqrt(n);

    for (int i = 2; i <= limit; i++) {
        if (n % i == 0) {
            return false;
        }
    }

    return true;
}
    public int countPrimes(int n) {
       int prime[] = new int[n+1];
       for(int i = 2;i<n;i++) prime[i] = 1;
       for(int i = 2;i<n;i++)
       {
            if(prime[i] == 1)
            {
                for(int j = 2*i;j<=n;j+=i)
                {
                    prime[j] = 0;
                }
            }
       }
       int cnt = 0;
       for(int i = 2;i<n;i++)
       {
        if(prime[i] == 1) cnt++;
       }
       return cnt;
    }
}