import java.util.*;

public class jioTest {

    public static String popStack(String s) {

        String ans = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int currC = (int) c;
            if (currC % 3 == 0) {
                stack.push(c);
            }
        }

        // Pop the stack
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }

    public static int uniqueDivisors(int n) {

        boolean hash[] = new boolean[n + 1];
        Arrays.fill(hash, true);
        for (int p = 2; p * p < n; p++)
            if (hash[p] == true)
                for (int i = p * 2; i < n; i += p)
                    hash[i] = false;
        int total = 1;
        for (int p = 2; p <= n; p++) {
            if (hash[p]) {
                int count = 0;
                if (n % p == 0) {
                    while (n % p == 0) {
                        n = n / p;
                        count++;
                    }
                    total = total * (count + 1);
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {

        System.out.println(popStack("abcdef"));

        System.out.println(uniqueDivisors(16));
    }

}
