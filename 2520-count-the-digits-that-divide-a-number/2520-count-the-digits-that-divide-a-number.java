class Solution {
    public int countDigits(int num) {
        int cnt=0;
        int dup=num;
        while(num>0)
        {
            int val=num%10;
            if(dup%val==0) cnt++;
            num=num/10;
        }
        return cnt;
    }
}