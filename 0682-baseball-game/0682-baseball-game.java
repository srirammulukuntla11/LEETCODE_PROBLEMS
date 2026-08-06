class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stk = new Stack<>();
        int v1 = 0;
        int v2 = 0;
        for(String op : operations)
        {
            if(op.equals("+"))
            {
                if(!stk.isEmpty())
                {
                    v1 = stk.pop();
                    v2 = stk.peek();
                    stk.push(v1);
                    stk.push(v1+v2);
                }
            }
            else if (op.equals("D"))
            {
                if(!stk.isEmpty())
                {
                    
                    v1 = stk.peek();
                    stk.push(v1*2);
                }
            }
            else if(op.equals("C"))
            {
                stk.pop();
            }
            else
            {
                stk.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        while(!stk.isEmpty())
        {
            sum = sum + stk.pop();
        }
        return sum;
    }
}