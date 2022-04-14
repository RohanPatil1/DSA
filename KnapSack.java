import java.util.*;

public class KnapSack {

    int knapsack(int[] wt, int[] val, int w, int n) {

        // If no item or bag is full
        if (n == 0 || w == 0) {
            return 0; // 0 Profit
        }

        if (wt[n - 1] <= w) {
            return Math.max(
                    val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1),
                    knapsack(wt, val, w, n - 1)

            );
        } else {
            return knapsack(wt, val, w, n - 1);
        }

    }

    /// TopDown- Memoization Approach

    static int[][] t = new int[21][21];
    // Initialized with -1 in main()

    int knapsackTOD(int[] wt, int[] val, int w, int n) {

        // If no item or bag is full
        if (n == 0 || w == 0) {
            return 0; // 0 Profit
        }

        // if we have value then use this
        if (t[n][w] != -1) {
            return t[n][w];
        }

        if (wt[n - 1] <= w) {
            return t[n][w] = Math.max(
                    val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1),
                    knapsack(wt, val, w, n - 1)

            );
        } else {
            return t[n][w] = knapsack(wt, val, w, n - 1);
        }

    }

    /// Bottom-Up Tabulation Approach
    int knapsackTabulation(int[] wt, int[] val, int w, int n) {
        int[][] dp = new int[n + 1][w + 1];

        // Init first row and column with 0 according to the base condition
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        // Now fill the rest with ans
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {

                if (wt[i - 1] <= w) {
                    t[n][w] = Math.max(val[i - 1] + t[i - 1][w - wt[i - 1]], t[i - 1][w]);
                } else {
                    t[n][w] = t[i - 1][w];
                }
            }
        }

        return t[n][w];
    }

    public static void main(String[] args) {
        for (int[] row : t) {
            Arrays.fill(row, -1);

        }
    }
}
