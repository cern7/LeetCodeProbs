package stack;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] sChar = s.toCharArray();
        if (sChar.length < 2 || sChar.length % 2 != 0) {
            return false;
        }
        for (int i = 0; i < sChar.length; i++) {
            switch (sChar[i]) {
                case ('('):
                case ('['):
                case ('{'):
                    stack.push(sChar[i]);
                    break;
                case ('}'):
                    if (stack.isEmpty() || !stack.pop().equals('{'))
                        return false;
                    break;
                case (']'):
                    if (stack.isEmpty() || !stack.pop().equals('['))
                        return false;
                    break;
                case (')'):
                    if (stack.isEmpty() || !stack.pop().equals('('))
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }

}
