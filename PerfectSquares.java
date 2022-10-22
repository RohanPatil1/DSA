import java.util.Arrays;

public class PerfectSquares {
    public int solve(int n) {
        if (n == 0) return 0;

        int ans = n;

        for (int i = 1; i * i <= n; i++) {
            ans = Math.min(ans, 1 + solve(n - i * i));
        }

        return ans;
    }


    public int MinSquares(int n) {

        return solve(n);
    }


    public int MinSquaresTAB(int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {//target n
            for (int j = 1; j * j <= n; j++) {
                int sq = j * j;
                if ((i - j * j) < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }

        }

        return dp[n];
    }
}
