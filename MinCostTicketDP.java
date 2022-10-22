import java.util.Arrays;

public class MinCostTicketDP {


    //-------------A1--------------- Time=>Exponential After memoization Time=>O(365) i.e O(1)
    public int solve(int[] days, int[] costs, int index) {

        if (index >= days.length) return 0;


        int day1Pass = costs[0] + solve(days, costs, index + 1);

        int i = 0;
        for (i = index; i < days.length && days[i] < days[index] + 7; i++) ;
        int day7Pass = costs[1] + solve(days, costs, i);

        for (i = index; i < days.length && days[i] < days[index] + 30; i++) ;
        int day30Pass = costs[2] + solve(days, costs, i);


        return Math.min(day1Pass, Math.min(day7Pass, day30Pass));
    }


    public int mincostTickets(int[] days, int[] costs) {
        return solve(days, costs, 0);
    }

    //-------------A2--------------- Time=>O(n)
    public int mincostTicketsTAB(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        for (int k = days.length - 1; k >=0 ; k--) {
            int day1Pass = costs[0] + dp[k+1];

            int i=0;
            for(i = k; i<n && days[i] < days[k] + 7; i++);
            int day7Pass = costs[1] + dp[i];

            for(i = k; i<n && days[i] < days[k] + 30; i++);
            int day30Pass = costs[2] + dp[i];

            dp[k] = Math.min(day1Pass, Math.min(day7Pass, day30Pass));
        }

        return dp[0];
    }

}
