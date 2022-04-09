import java.util.*;

public class MinStack {

    // MinStack Using Space
    // ------------------------------------------------------------------------
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    int msGetMin() {
        if (stack2.isEmpty()) {
            return -1;
        } else {

            return stack2.peek();
        }
    }

    void msPush(int value) {
        stack.push(value);
        if (stack2.isEmpty() || stack2.peek() >= value) {
            stack2.push(value);
        }
    }

    int pop() {

        if (stack.isEmpty()) {
            return -1;
        }
        int popV = stack.pop();
        if (popV == stack2.peek()) {
            stack2.pop();
        }
        return popV;
    }
    // MinStack Using Space
    // ------------------------------------------------------------------------

    // MinStack Without Using Space
    // ------------------------------------------------------------------------
    Stack<Integer> s = new Stack<>();
    int min;

    int getMin() {
        if (s.isEmpty()) {
            return -1;
        }
        return min;
    }

    void push(int a) {
        if (s.isEmpty()) {
            s.push(a);
            min = a;
        } else {
            if (a >= min) {
                s.push(a);
            } else if (a < min) {
                s.push(2 * a - min);
                min = a;
            }
        }
    }

    void popp() {
        if (s.isEmpty()) {
            return;
        } else {
            if (s.peek() >= min) {
                s.pop();
            } else if (s.peek() < min) {
                min = 2 * min - s.peek();
                s.pop();
            }
        }
    }

    int top() {
        if (s.isEmpty()) {
            return s.peek();
        } else if (s.peek() < min) {
            return min;
        }
        return -1;
    }
    // MinStack Without Using Space
    // ------------------------------------------------------------------------

    public static void main(String[] args) {

    }
}
