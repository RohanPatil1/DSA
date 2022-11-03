public class PathWithMinSum {

    public int minPathSum(int[][] grid) {


        int n = grid.length;
        int m = grid[0].length;
        return solve(grid, n - 1, m - 1);
    }

    //Recursive
    public int solve(int[][] matrix, int i, int j) {

        if (i == 0 && j == 0)
            return matrix[0][0];

        if (i < 0 || j < 0)
            return (int) Math.pow(10, 9);

        int up = matrix[i][j] + solve(matrix, i - 1, j);
        int left = matrix[i][j] + solve(matrix, i, j - 1);

        return Math.min(up, left);

    }

    //Time=O(n*m) Space=O(n*m)
    public static int solveTab(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        int up=0,  left = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i==0 && j==0) dp[i][j] = grid[0][0];
                else{
                    if(i>0) up = grid[i][j] + dp[i - 1][j];
                    else up = (int) Math.pow(10, 9);

                    if(j>0) left = grid[i][j] + dp[i][j - 1];
                    else left = (int) Math.pow(10, 9);

                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    public static int solveTab2(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
//        int[][] dp = new int[n][m];
        int up=0,  left = 0;
        int[] prev = new int[m];
        int[] curr = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i==0 && j==0) curr[j] = grid[0][0];
                else{
                    if(i>0) up = grid[i][j] + prev[j];
                    else up = (int) Math.pow(10, 9);

                    if(j>0) left = grid[i][j] + curr[j - 1];
                    else left = (int) Math.pow(10, 9);

                    curr[j] = Math.min(up, left);
                }
            }
            prev = curr;
        }

        return prev[m - 1];
    }

}
