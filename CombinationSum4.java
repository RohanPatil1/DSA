public class CombinationSum4 {

    //This is different from Max Coins with target. Here we want all the combinations so 1+1+2 is different from 2+1+1

    //--------------A1---------------
    public int combinationSum4(int[] nums, int target) {

        int count = solve(nums, target);

        return count;
    }


    public int solve(int[] nums, int target) {


        if (target == 0) {
            return 1;
        }

        if (target < 0) return 0;

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += solve(nums, target - nums[i]);
        }
        return ans;
    }

    //--------------A2-----------tabulation----
    public int combinationSum4_A2(int[] nums, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {

            for (int num : nums) {
                if (i - num < 0) continue;
                dp[i] += dp[i - num];
            }

        }

        return dp[target];
    }


}
