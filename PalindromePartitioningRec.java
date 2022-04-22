import java.util.Arrays;

public class PalindromePartitioningRec {

    // public static boolean isPalindrom(String s) {

    // StringBuilder sb = new StringBuilder(s);
    // sb.reverse();
    // String rev = sb.toString();

    // if (s.indexOf(rev) == 0) {
    // return true;
    // }
    // return false;

    // }
    static boolean isPalindrom(String s, int i, int j) {
        while (j >= i) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                j--;
                i++;
            }
        }
        return true;
    }

    static int[][] t = new int[500][500];

    public static int palindromicPartition(String s) {
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        return pprt(s, 0, s.length() - 1);
    }

    public static int pprt(String s, int i, int j) {

        if (i >= j)
            return 0;

        if (t[i][j] != -1) {
            return t[i][j];
        }

        if (isPalindrom(s, i, j))
            return 0;

        int min = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int left, right;

            // Check if left is calculated
            if (t[i][k] != -1) {
                left = t[i][k];
            } else {
                left = pprt(s, i, k);
            }

            // Check if right is calculated
            if (t[k + 1][j] != -1) {
                right = t[k + 1][j];
            } else {
                right = pprt(s, k + 1, j);
            }

            int temp = 1 + left + right;
            min = Math.min(min, temp);
            t[i][j] = min;
        }

        return t[i][j];
    }

    public static void main(String[] args) {

        String s = "ababbbabbababa";

        System.out.println(palindromicPartition(s));

    }
}
