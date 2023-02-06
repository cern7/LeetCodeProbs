package stack;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    private Deque<Integer> internalStack;
    private Deque<Integer> internalMin;


    public MinStack() {
        internalStack = new LinkedList<>();
        internalMin = new LinkedList<>();
    }

    public void push(int val) {
        if (internalMin.isEmpty() || internalMin.peek() > val) {
            internalMin.push(val);
        }
        internalStack.push(val);
    }

    public void pop() {
        if (!internalStack.isEmpty()) {
            int tempMin = internalStack.pop();
            if (internalMin.peek() == tempMin && !internalStack.contains(tempMin)) {
                internalMin.pop();
            }
        }
    }

    public int top() {
        return internalStack.peek();
    }

    public int getMin() {
        return internalMin.peek();
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
