class Solution {
    public static int fibb(int n)
    {
        if(n<=1) return n;
        return fibb(n-1)+fibb(n-2);
    }
    public int fib(int n) {
        return fibb(n);
    }
}