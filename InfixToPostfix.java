import java.util.Stack;

public class InfixToPostfix {

    public static String infixToPostfix(String exp) {
        Stack<Character> ops = new Stack<>();
        Stack<String> post = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                ops.push(ch);
            } else if (Character.isLetterOrDigit(ch)) {
                post.push(ch + "");
            } else if (ch == ')') {
                while (ops.peek() != '(' && ops.size() > 0) {
                    char op = ops.pop();
                    String v2 = post.pop();
                    String v1 = post.pop();
                    post.push(v1 + v2 + op);
                }
                ops.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                while (ops.size() > 0 && ops.peek() != '(' && precedence(ch) <= precedence(ops.peek())) {
                    char op = ops.pop();

                    String postv2 = post.pop();
                    String postv1 = post.pop();
                    String postv = postv1 + postv2 + op;
                    post.push(postv);
                }
                ops.push(ch);
            }
        }
        while (ops.size() > 0) {
            char op = ops.pop();

            String postv2 = post.pop();
            String postv1 = post.pop();
            String postv = postv1 + postv2 + op;
            post.push(postv);
        }
        String t = post.pop();
        return t;

    }

    private static int precedence(char op) {
        if (op == '+' || op == '-')
            return 1;
        else if (op == '*' || op == '/')
            return 2;
        else if (op == '^')
            return 3;
        else
            return 0;
    }

    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b*(c^d-e)^(f+g*h)-i")
        );
    }

}
