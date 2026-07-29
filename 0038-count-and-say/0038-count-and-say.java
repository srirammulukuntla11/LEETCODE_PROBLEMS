class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String number="1";
        for(int i=2;i<=n;i++)
        {
            String res="";
            int cnt=1;
            char curr=number.charAt(0);
            for(int j=1;j<number.length();j++){
                if(number.charAt(j)==curr)
                {
                    cnt++;
                }
                else
                {
                    res+=String.valueOf(cnt)+curr;
                    curr=number.charAt(j);
                    cnt=1;
                }
                 
            }
            res+=String.valueOf(cnt)+curr;
                 number=res;
            
           


        }
        return number;

        
    }
}