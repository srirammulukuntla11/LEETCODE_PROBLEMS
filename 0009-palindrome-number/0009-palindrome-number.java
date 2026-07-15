class Solution {
    public boolean isPalindrome(int n) {
        int dup = n;
       
        int orgi = n;
        boolean isNeg = false;
        if(n < 0)
        {
             isNeg = true;
             n = Math.abs(n);
        }
        int revNo = 0;
        while(n>0)
        {
            int ld = n%10;
            revNo = revNo*10+ld;
            n = n/10;
        }
        if(isNeg)
        {
           return false;
        }
        return revNo == dup;
        
    }
}