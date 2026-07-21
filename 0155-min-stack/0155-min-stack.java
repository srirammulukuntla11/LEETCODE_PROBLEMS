import java.util.*;

class MinStack {

    private Stack<Long> stk;
    private long min;

    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int val) {
        long value = val;

        if (stk.isEmpty()) {
            stk.push(value);
            min = value;
        } 
        else {
            if (value > min) {
                stk.push(value);
            } 
            else {
                stk.push(2 * value - min);
                min = value;
            }
        }
    }
    
    public void pop() {
        long x = stk.pop();

        if (x < min) {
            min = 2 * min - x;
        }
    }
    
    public int top() {
        long x = stk.peek();

        if (x < min) {
            return (int) min;
        }
        return (int) x;
    }
    
    public int getMin() {
        return (int) min;
    }
}
