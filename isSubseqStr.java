import java.util.Stack;

public class isSubseqStr {

    public static boolean isSubseq1(String s, String t) {

        int index = -1;
        for (char c : s.toCharArray()) {

            index = t.indexOf(c, index + 1);
            if (index == -1) return false;
        }

        return true;
    }



    public boolean isSubseq2(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i += 1;
            }
            j += 1;
        }
        return i == s.length();
    }

    public boolean isSubseq3(String s, String t) {
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            stack.push(s.charAt(i));
        }
        for (char c : t.toCharArray()) {
            if (stack.isEmpty()) return true;
            if (c == stack.peek()) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
