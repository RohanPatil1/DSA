import java.util.Stack;

public class EvaluationOfPostfix {

    public static int getPostfix(String expr) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char curr = expr.charAt(i);

            if (Character.isDigit(curr)) {
                stack.push(curr - '0');
            } else {
                int x = stack.pop();
                int y = stack.pop();

                if (curr == '+') {
                    stack.push(x + y);
                } else if (curr == '*') {
                    stack.push(x * y);
                } else if (curr == '/') {
                    stack.push(x / y);
                } else if (curr == '-') {
                    stack.push(x - y);
                }
            }
        }
        return stack.peek();
    }
}
