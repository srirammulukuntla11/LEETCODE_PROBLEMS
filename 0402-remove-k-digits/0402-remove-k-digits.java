import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);

            while(!stk.isEmpty() && k > 0 && stk.peek() > c) {
                stk.pop();
                k--;
            }

            stk.push(c);
        }

        // remove remaining digits
        while(k > 0 && !stk.isEmpty()) {
            stk.pop();
            k--;
        }

        if(stk.isEmpty()) return "0";

        StringBuilder res = new StringBuilder();

        while(!stk.isEmpty()) {
            res.append(stk.pop());
        }

        res.reverse();

        // remove leading zeros
        while(res.length() > 1 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }

        return res.toString();
    }
}