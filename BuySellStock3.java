import java.util.HashMap;
import java.util.Map;

public class BuySellStock3 {
    Map<String, Integer> map = new HashMap<>();
    public int solve(int[] arr, int i, int canBuy, int transactions){



        if(i == arr.length || transactions == 0){
            return 0;
        }


        if(map.containsKey(i+canBuy+transactions+""))
            return map.get(i+canBuy+transactions+"");


        if(canBuy == 1){
            int maxProfit = Math.max(
                    -arr[i] + solve(arr, i+1, 0, transactions),
                    0 + solve(arr, i+1, 1, transactions)
            );

            map.put(i+canBuy+transactions+"", maxProfit);

        }

        int maxProfit = Math.max(
                arr[i] + solve(arr, i+1, 1, transactions-1),
                0 + solve(arr, i+1, 0, transactions)
        );

        map.put(i+canBuy+transactions+"", maxProfit);
        return maxProfit;

    }

    //-------Tabulation using dp[i+1][buy][trans]
    //----Space Optimization
    public int maxProfitTab2(int[] arr) {

        int n = arr.length;

        // int[][][] dp = new int[n+1][3][3];
        int[][] after = new int[3][3];
        int[][] curr = new int[3][3];

        for(int i=n-1;i>=0;i--){
            for(int buy = 0;buy<=1;buy++){
                for(int trans = 1;trans<=2; trans++){


                    if(buy==1){
                        curr[buy][trans] = Math.max(-arr[i] + after[0][trans], 0 + after[1][trans]);
                    }else{
                        curr[buy][trans] = Math.max(arr[i] + after[1][trans-1], 0 + after[0][trans]);
                    }

                }

            }
            after = curr;

        }

        return after[1][2];


    }
}
