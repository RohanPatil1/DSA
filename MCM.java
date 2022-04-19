import java.util.*;

public class MCM {

    static int[][] t = new int[101][101];

    public static int mcmTD(int[] arr, int i, int j) {
        if (i >= j) {
            return t[i][j] = 0;
        }
        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int tempAns = mcmTD(arr, i, k) + mcmTD(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            if (min > tempAns) {
                min = tempAns;
            }
        }

        return t[i][j] = min;
    }

    public static int getMCM(int[] arr, int i, int j) {

        if (i >= j) {
            return 0;
        }

        if (t[i][j] != -1) {
            return t[i][j];
        }

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int tempAns = getMCM(arr, i, k) + getMCM(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            if (min > tempAns) {
                min = tempAns;
            }

        }

        return min;
    }

    public static void main(String[] args) {

        int[] ar = new int[] { 40, 20, 10, 30 };

        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        System.out.println(getMCM(ar, 1, 3));
        System.out.println(mcmTD(ar, 1, 3));

    }
}
