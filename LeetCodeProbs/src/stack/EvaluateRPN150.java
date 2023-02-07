package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateRPN150 {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];
            switch (t) {
                case "+" -> {
                    int tempSum = stk.pop() + stk.pop();
                    stk.push(tempSum);
                }
                case "-" -> {
                    int tempMinus = -stk.pop() + stk.pop();
                    stk.push(tempMinus);
                }
                case "*" -> {

                    int tempMult = stk.pop() * stk.pop();
                    stk.push(tempMult);
                }
                case "/" -> {
                    int divisor = stk.pop();
                    int dividend = stk.pop();
                    int tempDiv = dividend / divisor;
                    stk.push(tempDiv);
                }
                default -> {
                    stk.push(Integer.parseInt(tokens[i]));
                }
            }
        }
        return stk.pop();
    }
}
