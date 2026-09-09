class Solution {
    public static boolean prime(int val)
    {
        if(val < 2) return false;
        for(int i = 2;i*i <= val;i++)
        {
            if(val%i == 0)
            {
                return false;
            }
        }
        return true;
    }
    public int diagonalPrime(int[][] nums) {
        int largest_prime = 0;
        int n = nums.length;
        int m = nums[0].length;
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(i==j || i+j == n-1)
                {
                    if(prime(nums[i][j]))
                    {
                        largest_prime = Math.max(largest_prime,nums[i][j]);
                    }
                }
            }
        }
        return largest_prime;
    }
}