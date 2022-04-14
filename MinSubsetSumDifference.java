import java.util.*;

public class MinSubsetSumDifference {

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

    public static int minSSDiff(int[] arr) {

        int n = arr.length;
        int range = 0;

        // Get range
        for (int x : arr) {
            range += x;
        }

        // Validate sums

        int s = range/2;
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

        // ArrayList<Integer> rangeArr = new ArrayList<>();

        // // Fill Range Arr
        // for (int i = 0; i <= range / 2; i++) {

        // // System.out.println(i+": "+t[n][i]);
        // if (t[n][i]) {

        // rangeArr.add(i);
        // }
        // }

        // System.out.println(rangeArr.toString());

        // int min = Integer.MAX_VALUE;
        // for (int i = 0; i < rangeArr.size(); i++) {
        // int currDiff = Math.abs(range - 2 * rangeArr.get(i));
        // min = Math.min(min, currDiff);
        // }

        // Get the last true value in the row of t i.e max value from rangeArr
        int x = range / 2;
        while (!t[n][x])
            x--;
        return range - 2 * x;

    }

    public static void main(String[] args) {

        int ans = minSSDiff(new int[] { 1, 6, 11, 5 });
        System.out.println(ans);
    }
}
