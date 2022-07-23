import java.util.Arrays;

public class BuyingVegetables {

    static int[][] t = new int[100001][3];

    static int recursion(int i, int[][] cost, int prev) {
        if (i == cost.length) return 0;

        if (prev == -1) {
            int a = cost[i][0] + recursion(i + 1, cost, 0);
            int b = cost[i][1] + recursion(i + 1, cost, 1);
            int c = cost[i][2] + recursion(i + 1, cost, 2);
            return Math.min(a, Math.min(b, c));
        } else if (t[i][prev] != -1) return t[i][prev];
        else {
            int ans = Integer.MAX_VALUE;
            for (int j = 0; j <= 2; j++) {
                if (j == prev) continue;

                ans = Math.min(ans, cost[i][j] + recursion(i + 1, cost, j));
            }
            return t[i][prev] = ans;
        }
    }


    static int minCost(int N, int cost[][]) {
        for(int[] arr:t) Arrays.fill(arr,-1);
        return recursion(0, cost, -1);
    }

    public static void main(String[] args) {
        int[][] c = new int[][]{{1, 50, 50},
                {50, 50, 50},
                {1, 50, 50}};
        System.out.println(minCost(c.length, c));
    }

}