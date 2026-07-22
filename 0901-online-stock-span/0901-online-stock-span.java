import java.util.*;

class StockSpanner {

    Stack<int[]> stk;
    int index;

    public StockSpanner() {
        stk = new Stack<>();
        index = -1;
    }
    
    public int next(int price) {
        index++;

        while(!stk.isEmpty() && stk.peek()[0] <= price) {
            stk.pop();
        }

        int ans = index - (stk.isEmpty() ? -1 : stk.peek()[1]);

        stk.push(new int[]{price, index});

        return ans;
    }
}