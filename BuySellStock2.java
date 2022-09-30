import java.util.Arrays;

public class BuySellStock2 {

    int[][] dp = new int[30001][3];
    public int maxProfit(int[] arr) {

        for(int[] a : dp){
            Arrays.fill(a , -1);
        }

        return solve(arr, 0, 1);

    }

    public int solve(int[] arr, int i, int canBuy){

        if(arr.length == i){
            return 0;
        }

        if(dp[i][canBuy] != -1) return dp[i][canBuy];

        int maxProfit = 0;
        if(canBuy==1){
            int ans1 = -arr[i] + solve(arr, i+1, 0);
            int ans2 = 0 + solve(arr,i+1,1);

            maxProfit = Math.max(ans1, ans2);
        }else{
            //Sell
            int ans1 = arr[i] + solve(arr, i+1, 1);
            int ans2 = 0 + solve(arr, i+1, 0);

            maxProfit = Math.max(ans1, ans2);
        }

        return dp[i][canBuy] = maxProfit;
    }

}
