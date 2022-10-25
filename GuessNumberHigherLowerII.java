public class GuessNumberHigherLowerII {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+2][n+2];
        // for(int[] a : dp) Arrays.fill(a , -1);
        // return solve(1, n, dp);

        for(int start = n; start>=1; start--){
            for(int end = start; end<=n; end++){

                if(start == end) continue;

                int ans = Integer.MAX_VALUE;
                for(int i=start; i<=end; i++){

                    ans = Math.min(ans, i + Math.max( dp[start][i-1], dp[i+1][end]));
                    dp[start][end] = ans;
                }
            }
        }


        return dp[1][n];
    }

    int solve(int start, int end, int[][] dp){

        if(start >= end) return 0;

        if(dp[start][end] != -1) return dp[start][end];

        int ans = Integer.MAX_VALUE;
        for(int i=start; i<=end; i++){

            ans = Math.min(ans, i + Math.max( solve(start , i-1, dp), solve(i+1, end, dp) ));

        }

        return dp[start][end] = ans;
    }


}
