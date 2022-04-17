import java.util.*;

public class LongestCommonSubseq {

    public static int lcsRec(String x, String y, int n, int m) {

        if (n == 0 || m == 0) {
            return 0;
        }

        if (x.charAt(n - 1) == y.charAt(m - 1)) {
            return 1 + lcsRec(x, y, n - 1, m - 1);
        } else {
            return Math.max(lcsRec(x, y, n - 1, m), lcsRec(x, y, n, m - 1));
        }

    }

    static int lcsBUP(int n, int m, String x, String y) {
        // your code here
        int[][] t = new int[n + 1][m + 1];

        // Init
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        // Fill the rest with ans
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }

            }
        }

        return t[n][m];
    }

    public static String printLCS(String x, String y) {
        int n = x.length();
        int m = y.length();

        String ans = "";

        // READY THE MATRIX
        int[][] t = new int[n + 1][m + 1];

        // Init
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        // Fill the rest with ans
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }

            }
        }

        m = x.length();
        n = y.length();
        while (m > 0 && n > 0) {

            if (x.charAt(m - 1) == y.charAt(n - 1)) {
                ans += x.charAt(m - 1);
                m--;
                n--;
            } else {
                if (t[m - 1][n] > t[m][n - 1]) {
                    m--;
                } else {
                    n--;
                }

            }
        }

        StringBuilder sb = new StringBuilder(ans);
        sb.reverse();
        return sb.toString();
    }

    // Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X, String Y, int m, int n) {
        // Your code here

        // Get LCS
        int lcs = lcsBUP(m, n, X, Y);
        return m + n - lcs;

    }

    public static void main(String[] args) {

        String x = "abcdgh";
        String y = "abedyhr";

        System.out.println(lcsRec(x, y, x.length(), y.length()));
        System.out.println(printLCS("ABCDGH", "ADH"));
    }
}
