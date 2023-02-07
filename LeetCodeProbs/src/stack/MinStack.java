package stack;

public class MinStack {

    class Node {
        int val;
        int min;
        Node next;

        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }

    }

    int min;
    Node node;
    Node head;

    public MinStack() {
    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, head);
            min = val;
        } else {
            int tempMin = min < val ? min : val;
            head = new Node(val, tempMin, head);
            min = tempMin;
        }
    }

    public void pop() {
        if (head.next != null) {
            min = head.next.min;
            head = head.next;
        } else {
            head = null;
            min =-1;
        }
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return min;
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
