public class DP01Knapsack {


    //Get the maxProfit
    public static int knapsackRec(int[] wt, int[] val, int W) {


        return solve(wt, val, W, wt.length);

    }

    public static int solve(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) {
            int include = val[n - 1] + solve(wt, val, W - wt[n - 1], n - 1);
            int notInclude = solve(wt, val, W, n - 1);
            return Math.max(include, notInclude);
        }
        return solve(wt, val, W, n - 1);
    }


    //Memoization
    static int[][] t = new int[1001][1001];

    public static int solve2(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (t[n][W] != -1) {
            return t[n][W];
        }

        int include = 0, notInclude = 0;
        if (wt[n - 1] <= W) {
            include = val[n - 1] + solve(wt, val, W - wt[n - 1], n - 1);
        }
        notInclude = solve(wt, val, W, n - 1);
        return t[n][W] = Math.max(include, notInclude);

    }

    //------Bottom Ups Approach
    public static int knapsackBUP(int[] wt, int[] val, int W) {

        int n = wt.length;
        int[][] t = new int[n + 1][W + 1];

        //init
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        //Fill the rest with ans
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (wt[i - 1] <= j) {
                    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][W];
    }


}

