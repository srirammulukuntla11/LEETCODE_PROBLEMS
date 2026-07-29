class Solution {
    public int calculate(String s) {
        int sign = 1;
        int currNo = 0;
        int ans = 0;
        Stack<Integer> stk = new Stack<>();
        int n = s.length();
        for(int i = 0;i<n;i++)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                currNo = s.charAt(i) - '0';
                while(i+1 < n && Character.isDigit(s.charAt(i+1)))
                {
                    currNo = currNo*10+(s.charAt(i+1) - '0');
                    i++;
                }
                currNo = currNo*sign;
                ans = ans + currNo;
                currNo = 0;
                sign = 1;
            }
            else if (s.charAt(i) == '+')
            {
                sign = 1;
            }
            else if (s.charAt(i) == '-') sign = -1;
            else if (s.charAt(i) == '(')
            {
                stk.push(ans);
                ans = 0;
                stk.push(sign);
                sign = 1;
            }
            else if(s.charAt(i) == ')')
            {
                int prevsign = stk.pop();
                ans = ans*prevsign;
                int prevans = stk.pop();
                ans += prevans; 
            }
        }
        return ans;
    }
}