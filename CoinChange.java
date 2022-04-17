import java.util.*;

public class CoinChange {

    public static int getMaxWaysCC(int[] coins, int s) {
        int count = 0;
        int n = coins.length;
        int[][] t = new int[n + 1][s + 1];

        // Init
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < s + 1; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                }
                if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        // Fill the rest with ans
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < s + 1; j++) {
                if (coins[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] + t[i][j - coins[i - 1]];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        count = t[n][s];
        return count;
    }

    public static int getMinCoinsCC(int[] coins, int n, int s) {
        int[][] t = new int[n + 1][s + 1];

        // Init
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < s + 1; j++) {
                if (i == 0) {
                    t[i][j] = Integer.MAX_VALUE - 1;
                }
                if (j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        // Fill with ans
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < s + 1; j++) {
                if (coins[i - 1] <= j) {
                    t[i][j] = Math.min(t[i][j - coins[i - 1]] + 1, t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        /*
         * take eg s=15 and coins=[4]
         * here we will add 4+4+4+.... but the sum won't become 15
         * so we need to return -1 in this case
         * 
         * COINS CANT EXCEED SUM
         */
        // If infinte ways return -1
        if (t[n][s] == Integer.MAX_VALUE - 1) {
            return -1;
        }

        return t[n][s];
    }

    // Min Coins Recursive Approach
    int coinChangeII(int coin[], int sum, int n) {
        // given array of coins, o/p the minimum number of coins required to form sum.
        // can be unbounded knapsack.
        if (sum == 0 && n > 0) {
            return 0; // we don't need any number of coins
        }
        if (n == 0 && sum >= 0) {
            return Integer.MAX_VALUE - 1; // when bag has 0 coins, and we need to make the sum to S, then infinite coins
                                          // would be required.
        }

        if (coin[n - 1] <= sum) {
            return Math.min(1 + coinChangeII(coin, sum - coin[n - 1], n), coinChangeII(coin, sum, n - 1));
        } else {
            return coinChangeII(coin, sum, n - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(getMaxWaysCC(new int[] { 1, 2, 3 }, 5));

        System.out.println(getMinCoinsCC(new int[] { 25, 10, 5 }, 3, 30));

    }
}
