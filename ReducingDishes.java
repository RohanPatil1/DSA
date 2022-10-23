import java.util.Arrays;

public class ReducingDishes {

    //--------A1------------Time=O(2^n)
    public int maxSatisfaction(int[] satisfaction) {

        Arrays.sort(satisfaction);
        return solve(satisfaction, 1, 0);

    }

    public int solve(int[] arr, int time, int index) {

        if (index == arr.length) return 0;


        int include = arr[index] * time + solve(arr, time + 1, index + 1);
        int notInclude = solve(arr, time, index + 1);


        return Math.max(include, notInclude);
    }

    //------------A2--------
    public int maxSatisfactionTAB(int[] satisfaction) {
        int n = satisfaction.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int time = index; time >= 0; time--) {
                int include = satisfaction[index] * (time+1) + dp[time + 1][index + 1];
                int notInclude = dp[time][index + 1];


                dp[time][index] = Math.max(include, notInclude);
            }
        }

        return dp[0][0];
    }


    //------------A3----Greedy O(NLogN)
    public int maxSatisfactionGreedy(int[] A) {
        Arrays.sort(A);
        int res = 0, total = 0, n = A.length;
        for (int i = n - 1; i >= 0 && A[i] > -total; --i) {
            total += A[i];
            res += total;
        }
        return res;
    }

}
