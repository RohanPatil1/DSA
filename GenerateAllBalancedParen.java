import java.util.*;

public class GenerateAllBalancedParen {
//Time= O(2^2n) Exponential
    public static void gbpHelper(String op, int o, int c, ArrayList<String> ans) {
        if (o == 0 && c == 0) {
            ans.add(op);
            return;
        }

        if (o != 0) {
            String op1 = op + "(";
            gbpHelper(op1, o - 1, c, ans);
        }

        if (c > o) {

            String op2 = op + ")";
            gbpHelper(op2, o, c - 1, ans);

        }

    }

    public static ArrayList<String> gbp(int n) {

        ArrayList<String> ans = new ArrayList<>();
        int close = n;
        int open = n;
        String op = "";
        gbpHelper(op, open, close, ans);
        return ans;
    }

    public static void main(String[] args) {

        int n = 3;
        System.out.println(gbp(n).toString());
    }
}
