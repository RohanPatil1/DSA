import java.util.Stack;

public class RemoveKDigits {

    public static String removeKDigit(String s, int k) {


        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            while (k > 0 && !stack.isEmpty() && stack.peek() > curr) {
                stack.pop();
                k--;
            }
            stack.push(curr);
        }

        //remove increasing order
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        char ans[] = new char[stack.size()];
        int h = ans.length - 1;
        while (h >= 0) ans[h--] = stack.pop();


        //Remove leading zeros
        int d = 0;
        while (d < ans.length && ans[d] == '0') d++;

        StringBuilder sb = new StringBuilder();
        while (d < ans.length) sb.append(ans[d++]);
        if (sb.length() == 0) sb.append("0");
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(removeKDigit("14532219", 3));
    }
}
