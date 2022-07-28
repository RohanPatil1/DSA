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
        System.out.println(t[0][n-1]);
    }


    public static void main(String[] args) {
            countPalindrome("aab");
    }
}
