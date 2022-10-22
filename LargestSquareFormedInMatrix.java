public class LargestSquareFormedInMatrix {

    //-------A1---
    static int maxArea = 0;

    static int maxSquare(int n, int m, int mat[][]) {

        solve(mat, 0, 0);
        return maxArea;
    }


    static int solve(int[][] mat, int i, int j) {
        if (i >= mat.length || j >= mat[0].length) return 0;

        int right = solve(mat, i, j + 1);
        int down = solve(mat, i + 1, j);
        int diagonal = solve(mat, i + 1, j + 1);

        int ans;
        if (mat[i][j] == 1) {
            ans = 1 + Math.min(right, Math.min(down, diagonal));
            maxArea = ans;
        } else {
            return 0;
        }

        return ans;
    }

    //-------A2------TAB----- Time=O(n*m)
    static int maxSquareTAB(int n, int m, int mat[][]) {

        int[][] dp = new int[n][m];
        int maxArea = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int right = dp[i][j + 1];
                int down = dp[i + 1][j];
                int diagonal = dp[i + 1][j + 1];

                if (mat[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(right, Math.min(down, diagonal));
                    maxArea = Math.max(maxArea, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxArea;
    }


}
