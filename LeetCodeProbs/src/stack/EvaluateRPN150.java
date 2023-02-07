package stack;

public class EvaluateRPN150 {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        int[] stack = new int[tokens.length / 2 + 1];
        int j = 0;
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+" -> {
                    stack[j - 2] += stack[j - 1];
                    j--;
                }
                case "-" -> {
                    stack[j - 2] -= stack[j - 1];
                    j--;
                }
                case "*" -> {
                    stack[j - 2] *= stack[j - 1];
                    j--;
                }
                case "/" -> {
                    stack[j - 2] /= stack[j - 1];
                    j--;
                }
                default -> {
                    stack[j++] = Integer.parseInt(tokens[i]);
                }
            }
        }
        return stack[0];
    }
}
