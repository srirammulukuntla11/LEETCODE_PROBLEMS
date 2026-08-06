class Solution {
    public int smallestNumber(int n, int t) {
        int i = n;
        while(i >= n)
        {
            int dup = i;
            int pro = 1;
            while(dup > 0)
            {
                int ld = dup % 10;
                if(ld == 0)
                {
                    pro = 0;
                    break;
                }
                pro = pro * ld;
                dup = dup/10;
            }
            if(pro % t == 0) return i;
            i++;

        }
        return 0;
    }
}