import java.util.*;

public class ShortestCommonSubSeq {

    public static int getLCS(String x, String y, int n, int m) {
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
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }

        return t[n][m];
    }

    public static int getScsLen(String x, String y) {
        int ans = 0;

        int m = x.length();
        int n = y.length();
        int lcs = getLCS(x, y, m, n);
        return ans;
    }

    public static String printSCS(String x, String y, int n, int m) {
        String ans = "";

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
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }

        int i = x.length(), j = y.length();
        while (i > 0 && j > 0) {

            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                ans += x.charAt(i-1);
                i--;
                j--;
            } else {

                if (t[i - 1][j] > t[i][j - 1]) {
                    ans += x.charAt(i-1);
                    i--;
                } else {
                    ans += y.charAt(j-1);
                    j--;
                }

            }

        }
    
        while(i>0){
            ans += x.charAt(i-1);
            i--;
        }
        while(j>0){
            ans +=y.charAt(j-1);
            j--;
        }
    
        StringBuilder sb = new StringBuilder(ans);
        sb.reverse();

        return sb.toString();
    }

    public static void main(String[] args) {
        String x = "dcba";
        String y = "abcd";
        System.out.println(printSCS(x, y, x.length(), y.length()));
    }
}
