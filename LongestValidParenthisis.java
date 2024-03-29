import java.util.*;

//https://youtu.be/SDTdWMuP5a8
public class LongestValidParenthisis {


    //Without using 2 stacks just 1 index stack
    public static int validP(String s) {
        int resLen = 0;
        int n= s.length();

        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(-1);

        for(int i=0;i<n;i++){

            char curr = s.charAt(i);

            if(curr == '('){
                indexStack.push(i);
            }else{
                indexStack.pop();
                if(indexStack.isEmpty()){
                    indexStack.push(i);
                }else{
                    resLen = Math.max(resLen , i - indexStack.peek());
                }


            }
        }

        return resLen;
    }

    //O(1) space using two pointers
    public static int lvp(String s) {
        int n = s.length();
        int result = 0;

        int left = 0, right = 0;

        //From prefix
        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            if (curr == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right)
                result = Math.max(result, 2 * right);
            else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;

        //From suffix
        for (int i = n - 1; i > 0; i--) {
            char curr = s.charAt(i);
            if (curr == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                result = Math.max(result, 2 * right);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }


        return result;
    }

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
