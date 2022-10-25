import java.util.Arrays;

public class    DiceTargetSum {

    int mod = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {

        int[][] dp = new int[n+1][target+1];

        for(int[] arr: dp) Arrays.fill(arr, -1);

        return solve(n, k, target,dp);


    }
    //------------Recursion Memo

    public int solve(int dice, int faces, int t, int[][] dp){

        if(t<0) return 0;

        if(dice == 0 && t != 0) return 0;

        if(dice != 0 && t == 0) return 0;

        if(dice == 0 && t == 0) return 1;

        if(dp[dice][t] != -1) return dp[dice][t];

        int ways = 0;
        for(int i=1;i<=faces;i++){

            ways = (ways + solve(dice-1, faces, t-i, dp)%mod)%mod;

        }

        return dp[dice][t] = ways;
    }

    //------------Tabulation
    static long noOfWays(int k , int d , int t) {
        // code here

        long[][] dp =new long[d+1][t+1];

        dp[0][0] = 1;

        for(int dice = 1;dice<=d; dice++){


            for(int target=1; target<=t; target++){
                long ways =0L;

                for(int i=1; i<=k; i++){

                    if((target - i) >= 0){

                        ways += dp[dice - 1][target - i];

                    }
                }
                dp[dice][target] = ways;
            }

        }

        return dp[d][t];
    }
}
