package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures739 {
    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        for (int i : new DailyTemperatures739().dailyTemperatures(arr)) {
            System.out.print(i + " ");
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] result = new int[size];
//        Arrays.fill(result, 0);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty()
                    && temperatures[i] > temperatures[stack.peek()]) {
                int peekIndex = stack.pop();
                result[peekIndex] = i - peekIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
