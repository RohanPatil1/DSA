import java.util.Arrays;

public class StairCase {


    static int[] t = new int[10001];


    //All Number of ways
    static int countStair(int n) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return 1;

        if (t[n] != -1) return t[n];

        int count = countStair(n - 1);
        count += countStair(n - 2);

        return t[n] = count % 1000000007;
    }

    //Minimum cost to reach n
    public static int recursion(int[] cost, int n) {
        if (n == 0) return cost[0];
        if (n == 1) return cost[1];


        int choice1 = cost[n] + recursion(cost, n - 1);
        int choice2 = cost[n] + recursion(cost, n - 2);
        return Math.min(choice1, choice2);

    }

    public static int minCostClimbingStairsRec(int[] cost) {

        int n = cost.length;
        int ans = Math.min(recursion(cost, 0), recursion(cost, 1));
        return ans;
    }

    /*

    Let dp[i] be the cost to climb the i-th staircase to from 0-th or 1-th step. Hence dp[i] = cost[i] + min(dp[i-1], dp[i-2]).
     Since dp[i-1] and dp[i-2] are needed to compute the cost of traveling from i-th step, a bottom-up approach can be used to
      solve the problem.
     */
    public static int minCostClimbingStairsBUP(int[] cost) {
        int n = cost.length;
        int[] t = new int[n + 1];
        t[0] = cost[0];
        t[1] = cost[1];
        for (int i = 2; i <= n; i++) {
            t[i] = cost[i] + Math.min(t[i - 1], t[i - 2]);
        }

        return Math.min(t[n - 1], t[n - 2]);
    }


    public static void main(String[] args) {
        Arrays.fill(t, -1);
        System.out.println(countStair(84));
    }
}
