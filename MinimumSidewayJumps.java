import java.util.Arrays;

public class MinimumSidewayJumps {


    //------------A1-------------
    public int solve(int[] obs, int lane, int position) {

        //If reached destination
        if (position == obs.length - 1) return 0;

        //If next position does not have obstacle
        if (lane != obs[position + 1]) {
            return solve(obs, lane, position + 1);
        } else {

            //Obstacle, need jump
            int ans = Integer.MAX_VALUE;

            for (int i = 1; i <= 3; i++) {

                //If its not the same lane we are currently at && If the lane we are jumping doesn't have obstacle
                if (lane != i && obs[position] != i) {
                    ans = Math.min(ans, 1 + solve(obs, i, position));
                }

            }
            return ans;
        }
    }


    public int minSideJumps(int[] obstacles) {
        return solve(obstacles, 2, 0);
    }

    //-----------A2------------TAB Time=O(n)
    public int minSideJumpsTAB(int[] obstacles) {

        int n = obstacles.length;
        int[][] dp = new int[4][n];
        for (int[] a : dp) Arrays.fill(a, (int) 1e9);
        dp[0][n] = 0;
        dp[1][n] = 0;
        dp[2][n] = 0;
        dp[3][n] = 0;

        for (int pos = n - 1; pos >= 0; pos--) {
            for (int lane = 1; lane <= 3; lane++) {

                if (lane != obstacles[pos]) {
                    dp[lane][pos] = dp[lane][pos + 1];
                } else {
                    //Obstacle, need jump
                    int ans = (int) 1e9;

                    for (int i = 1; i <= 3; i++) {
                        if (lane != i && obstacles[pos] != i) {
                            ans = Math.min(ans, 1 + dp[i][pos]);
                        }

                    }
                    dp[lane][pos] = ans;
                }
            }

        }

        //Not directly dp[2][0]
        //We can also jump from 2nd lane to 1st & 3rd on the 0th position so we check those values too & +1 for jumping from 2
        return Math.min(dp[2][0], 1 + Math.min(dp[1][0], dp[3][0]));
    }

}
