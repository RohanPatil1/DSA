import java.util.*;

public class LongestValidParenthisis {

    public static void main(String[] args) {
        String str = "))()(()";
        Stack<Character> stack = new Stack<>();
        Stack<Integer> ins = new Stack<>();
        ins.push(-1);
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(c);
                ins.add(i);
            } else if (c == ')') {

                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    ins.pop();
                    max = Math.max(max, i - ins.peek());
                } else {
                    // Didn't find pair, so add the problem index
                    ins.push(i);
                }

            }
        }

        System.out.println(max);

    }
}
