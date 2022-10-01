public class BuySellStock4 {

    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        int[][][] dp = new int[n+1][3][k+1];

        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int t=1;t<=k;t++){

                    if(buy==1){
                        dp[i][buy][t] = Math.max( -prices[i] + dp[i+1][0][t], 0 + dp[i+1][1][t] );
                    }else{
                        dp[i][buy][t] = Math.max( prices[i] + dp[i+1][1][t-1], 0 + dp[i+1][0][t] );
                    }


                }

            }

        }

        return dp[0][1][k];
    }
}
