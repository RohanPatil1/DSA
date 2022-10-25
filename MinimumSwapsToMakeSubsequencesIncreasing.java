import java.util.Arrays;

public class MinimumSwapsToMakeSubsequencesIncreasing {

    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int[] arr1 = new int[n + 1];
        int[] arr2 = new int[n + 1];

        arr1[0] = -1;
        arr2[0] = -1;
        int i = 1;
        int k = 1;
        for (int j = 0; j < n; j++) {
            arr1[i++] = nums1[j];
            arr2[k++] = nums2[j];
        }

        int[][] dp =new int[n+1][3];

        for(int[] a : dp) Arrays.fill(a, -1);

        return solve(arr1, arr2, 1, 0, dp);


    }

    private int solve(int[] nums1, int[] nums2, int i, int isSwapped, int[][] dp) {

        if (i == nums1.length) return 0;

        if(dp[i][isSwapped] != -1) return dp[i][isSwapped];

        int ans = Integer.MAX_VALUE;

        int prev1 = nums1[i - 1];
        int prev2 = nums2[i - 1];

        //Was previously swapped
        if (isSwapped == 1) {
            int temp = prev1;
            prev1 = prev2;
            prev2 = temp;
        }

        //No Swap required
        if (nums1[i] > prev1 && nums2[i] > prev2)
            ans = solve(nums1, nums2, i + 1, 0, dp);

        if (nums1[i] > prev2 && nums2[i] > prev1)
            ans = Math.min(ans, 1 + solve(nums1, nums2, i + 1, 1, dp));

        return dp[i][isSwapped] = ans;
    }
}
