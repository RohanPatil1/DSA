import java.util.*;

public class TargetSum {

    public static int targetSum(int[] arr, int target) {

        int count = 0;
        int sum = 0;

        int countZ = 0;
        // Get Sum
        for (int x : arr) {
            sum += x;
            if (x == 0) {
                countZ++;
            }
        }

        // Edge cases
        if (sum < Math.abs(target) || (target + sum) % 2 != 0) {
            return 0;
        }

        int s1 = (sum-target) / 2;

        // Get count of subset with sum s1
        int n = arr.length;
        int s = s1;
        int[][] t = new int[n + 1][s + 1];

        // Init the matrix
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < s + 1; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                }
                if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        // Fill the rest with ans
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < s + 1; j++) {

                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] + t[i - 1][j - arr[i - 1]];
                } else if (arr[i - 1] > j || arr[i - 1] == 0) {
                    t[i][j] = t[i - 1][j];
                }

            }
        }

        count = t[n][s];
        int zeros = (int) Math.pow(2, countZ);
        return zeros * count;
    }

    public static void main(String[] args) {
        System.out.println(targetSum(new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1
        }, 1));
    }
}
