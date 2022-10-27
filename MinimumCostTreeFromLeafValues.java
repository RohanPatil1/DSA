public class MinimumCostTreeFromLeafValues {

    //Time => O(n^4)
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        return solve(arr, 0, n - 1, dp);

    }

    private int solve(int[] arr, int start, int end, int[][] dp) {

        if (start == end) return 0;

        if (dp[start][end] > 0) return dp[start][end];

        int ans = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {

            int leftSubTree = solve(arr, start, i, dp);
            int rightSubTree = solve(arr, i + 1, end, dp);

            int maxLeft = 0, maxRight = 0;
            for (int j = start; j <= i; j++) maxLeft = Math.max(maxLeft, arr[j]);
            for (int j = i + 1; j <= end; j++) maxRight = Math.max(maxRight, arr[j]);

            ans = Math.min(ans,maxLeft * maxRight + leftSubTree + rightSubTree);
        }


        return dp[start][end] = ans;
    }

    ///Compute max using pre-computation & reduce complexity to O(N^3)
    public int[][] calculateMaxRange(int[] a) {
        int[][] ans = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < a.length; j++) {
                max = Math.max(max, a[j]);
                ans[i][j] = max;
            }
        }
        return ans;
    }

    //https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/476513/Java-Mono-Stack-98-Example-to-explain

}
