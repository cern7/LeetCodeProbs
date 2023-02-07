package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses22 {

    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            return Arrays.asList("()");
        }
        List<String> result = new ArrayList<>();
        helper(n, 0, 0, new StringBuilder(""), result);
        return result;
    }

    private void helper(int n, int open, int closed, StringBuilder parentheses, List<String> set) {
        // add open parenth if open < n
        // add closing paranth if closed < open
        // valid if open == closed == n
        if (open == closed && open == n) {
            set.add(parentheses.toString());
            return;
        }
        if (open < n) {
            helper(n, open + 1, closed, parentheses.append("("), set);
            parentheses.deleteCharAt(parentheses.length() - 1);
        }
        if (closed < open) {
            helper(n, open, closed + 1, parentheses.append(")"), set);
            parentheses.deleteCharAt(parentheses.length() - 1);
        }
    }
}
