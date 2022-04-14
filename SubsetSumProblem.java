import java.util.*;

public class SubsetSumProblem {

    public static boolean subsetSum(int[] arr, int s) {

        int n = arr.length;
        boolean[][] t = new boolean[n + 1][s + 1];

        // Init matrix
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < s + 1; j++) {
                if (i == 0) {
                    t[i][j] = false;
                }
                if (j == 0) {
                    t[i][j] = true;
                }
            }
        }
        t[0][0] = true;

        // Fill rest with ans
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < s + 1; j++) {

                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][s];
    }

    public static boolean equalPartition(int[] arr, int n) {

        int sum = 0;
        for (int x : arr) {
            sum += x;
        }

        if (sum % 2 != 0) {
            return false;
        } else if (sum % 2 == 0) {
            return subsetSum(arr, sum / 2);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 7, 8, 10 };
        System.out.println(subsetSum(arr, 11));
        System.out.println(equalPartition(new int[]{1,5,6,11},arr.length));

    }
}
