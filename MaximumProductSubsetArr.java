public class MaximumProductSubsetArr {

    public static int maxProduct(int[] arr) {

        int ans = 1;
        int n = arr.length;

        int negCount = 0, zeroCount = 0, maxNeg = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                ans *= arr[i];
            } else if (arr[i] < 0) {
                negCount++;
                maxNeg = Math.max(maxNeg, arr[i]);
                ans *= arr[i];
            } else {
                zeroCount++;
            }
        }
        if (zeroCount == n || (zeroCount + negCount) == n) {
            return 0;
        }
        if (negCount % 2 != 0) {
            ans = ans / maxNeg;
        }
        return ans % 1000000007;
    }

}
