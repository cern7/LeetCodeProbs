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
        helper(n, 0, 0, "", result);
        return result;
    }

    private void helper(int n, int open, int closed, String parentheses, List<String> set) {
        // add open parenth if open < n
        // add closing parenth if closed < open
        // valid if open == closed == n
        if (open == closed && open == n) {
            set.add(parentheses);
        }
        if (open < n) {
            helper(n, open + 1, closed, parentheses + "(", set);
        }
        if (closed < open) {
            helper(n, open, closed + 1, parentheses + ")", set);
        }
    }
}
