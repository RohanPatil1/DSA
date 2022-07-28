import java.util.Arrays;

public class GoldMineProblem {

    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static int maxGold(int[][] M, int n, int m) {
        int[][] dp = new int[n][m];
        //n stands for the number of rows whereas m stands for the number of columns
        for (int j = m - 1; j >= 0; j--) {
            for (int i = n - 1; i >= 0; i--) {
                if (j == m - 1) {
                    dp[i][j] = M[i][j];
                } else if (i == 0 && n == 1) {
                    dp[i][j] = M[i][j] + dp[i][j + 1];
                } else if (i == 0 && n > 1) {
                    dp[i][j] = M[i][j] + Math.max(dp[i + 1][j + 1], dp[i][j + 1]);
                } else if (i == n - 1) {
                    dp[i][j] = M[i][j] + Math.max(dp[i - 1][j + 1], dp[i][j + 1]);
                } else {
                    dp[i][j] = M[i][j] + Math.max(Math.max(dp[i + 1][j + 1], dp[i][j + 1]), dp[i - 1][j + 1]);
                }

            }
//            printMatrix(dp);
//            System.out.println("-----" + j);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i][0]);
        }

        return max;
    }

    //-----------Recursive Approach---------
    static int[][] t = new int[51][51];

    public static int recursion(int[][] gold, int i, int j) {

        if (j >= gold[0].length) return 0;
        if (i >= gold.length || i < 0) return 0;

        if (t[i][j] != -1) return t[i][j];

        int x = recursion(gold, i - 1, j + 1);
        int y = recursion(gold, i, j + 1);
        int z = recursion(gold, i + 1, j + 1);
        return t[i][j] = gold[i][j] + Math.max(x, Math.max(y, z));
    }

    public static int maxGoldRec(int[][] gold, int n, int m) {
        int gMax = 0;

        for (int[] arr : t) Arrays.fill(arr, -1);
        for (int i = 0; i < n; i++) {
            gMax = Math.max(gMax, recursion(gold, i, 0));

        }


        return gMax;
    }


    public static void main(String[] args) {
        int[][] m = new int[][]{{1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}};

        System.out.println(maxGold(m, m.length, m[0].length));
        System.out.println(maxGoldRec(m, m.length, m[0].length));
    }

}
