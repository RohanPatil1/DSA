import java.util.Arrays;

public class FibbonacciDP {


    //-----Memoize
    static long[] dp = new long[1001];

    static long recursion(long n) {
        if (n == 0) return n;
        if (n == 1) return n;
        if (dp[(int) n] != -1L) return dp[(int) n];
        return dp[(int) n] = (recursion(n - 1) + recursion(n - 2)) % 1000000007;
    }

    static long nthFibonacci(long n) {
        // code here
        dp = new long[(int) n + 1];
        Arrays.fill(dp, -1L);

        return recursion(n);
    }


    static long nthFibonacciBUP(long n) {
        // code here

        long[] t = new long[(int) n + 1];
        t[0] = 0;
        t[1] = 1;
        for (int i = 2; i <= n; i++) {
            t[i] = t[i - 1] + t[i - 2];
        }
        return t[(int) n];
    }

    // You can optimize the space by using taking variables (prev1) (prev2)
    //curr = prev1 + prev2 Space O(1)
    public static void main(String[] args) {

    }
}
