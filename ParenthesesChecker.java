import java.util.Stack;

public class ParenthesesChecker {
    static boolean ispar(String x) {
        // add your code here
        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < x.length(); i++) {
            char curr = x.charAt(i);

            if (curr == '(' || curr == '{' || curr == '[') {
                stack.push(curr);
            } else if (curr == ')') {

                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }


            } else if (curr == '}') {

                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }


            } else if (curr == ']') {

                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }


            }


        }

        if (stack.isEmpty())
            return true;

        return false;
    }
}
