import java.util.*;

public class LongestPalindromSubseq {

    // Take a reverse of s, find lcs of s,s2
    public static int getLPS(String s) {
        // Get reverse string
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String s2 = sb.toString();

        int n = s.length();
        int m = n;

        int[][] t = new int[n + 1][m + 1];

        // Init
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (n == 0 || m == 0) {
                    t[i][j] = 0;
                }
            }
        }

        // Fill thre rest with ans
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == s2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        return t[n][m];
    }

    public static void main(String[] args) {
        System.out.println(getLPS("agbcba"));
    }
}
