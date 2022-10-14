import java.util.Stack;

public class EvaluateReversePolishNotation {

    boolean isNumber(String s) {
        return s.chars().allMatch(Character::isDigit);
    }

    public int evalRPN(String[] tokens) {


        int a, b;
        Stack<Integer> stack = new Stack<Integer>();

        for (String s : tokens) {

            if (s.equals("+")) {
                stack.add(stack.pop() + stack.pop());
            } else if (s.equals("/")) {
                b = stack.pop();
                a = stack.pop();
                stack.add(a / b);
            } else if (s.equals("*")) {
                stack.add(stack.pop() * stack.pop());
            } else if (s.equals("-")) {
                b = stack.pop();
                a = stack.pop();
                stack.add(a - b);
            } else {
                stack.add(Integer.parseInt(s));
            }
        }


        return stack.peek();

    }

}
