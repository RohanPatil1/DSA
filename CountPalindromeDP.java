import java.util.Arrays;

public class CountPalindromeDP {


    public static void countPalindrome(String str) {

        int n = str.length();

        int[][] t = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) t[i][j] = 0;
                if (i == j) t[i][j] = 1;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (j > i) {
                    if (str.charAt(i) == str.charAt(j)) {
                        t[i][j] = t[i][j - 1] + t[i + 1][j] + 1;
                    } else {
                        t[i][j] = t[i + 1][j] + t[i][j - 1] - t[i + 1][j - 1];
                    }
                }
            }
        }
        System.out.println(t[0][n - 1]);
    }

    static int[][] dp = new int[1001][1001];

    public static int recursion(String str, int i, int j) {
        if (i > j) return 0;
        if (i == j) return 1;

        if (dp[i][j] != -1) return dp[i][j];
        if (str.charAt(i) == str.charAt(j)) {
            return dp[i][j] = 1 + recursion(str, i, j - 1) + recursion(str, i + 1, j);
        } else {
            return dp[i][j] = recursion(str, i, j - 1) + recursion(str, i + 1, j) - recursion(str, i + 1, j - 1);
        }
    }

    public static int countPalindromeRec(String str) {
        for (int[] arr : dp) Arrays.fill(arr, -1);


        return recursion(str, 0, str.length() - 1);
    }

    public static void main(String[] args) {
        countPalindrome("aab");
        System.out.println(countPalindromeRec("aab"));

    }
}
