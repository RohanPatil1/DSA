import java.util.Stack;

public class RemoveAdjDuplicatesString {


    //if k times repeat, remove
    public static String removeAdjDupl(String str, int k) {
        String res = "";
        Stack<CPair> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (stack.isEmpty()) {
                stack.push(new CPair(curr, 1));
            } else {
                if (stack.peek().c != curr) {
                    stack.push(new CPair(curr, 1));
                } else {
                    stack.peek().f++;
                    if (stack.peek().f == k) {
                        stack.pop();
                    }
                }
            }
        }


        while (!stack.isEmpty()) {
            while (stack.peek().f != 0) {
                res += stack.peek().c;
                stack.peek().f--;
            }
            stack.pop();
        }
        return res;
    }


    public static String removeAdjDuplicates(String str) {
        String orgStr = str;
        String resultStr = str;


        //If prev & curr String are the same means NO modification was done
        while (orgStr.length() != resultStr.length()) {
            //More Duplicates present
            orgStr = resultStr;
            resultStr = removeAdjDuplHelper(resultStr);
        }

        return resultStr;
    }

    private static String removeAdjDuplHelper(String str) {

        String res = "";
        int n = str.length();
        int i = 0;

        while (i < n) {
            if (i < (n - 1) && str.charAt(i) == str.charAt(i + 1)) {
                while (i < (n - 1) && str.charAt(i) == str.charAt(i + 1)) {
                    i++;
                }
            } else {
                res += str.charAt(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(removeAdjDupl("deeedbbcccbdaa", 3));
    }
}
