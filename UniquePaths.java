import java.util.*;

public class UniquePaths {

    //A1 Using Recursion + DP

    static int[][] t = new int[1001][1001];

    public static int noOfUqPaths(int a, int b, int i, int j) {
        if (i == a - 1 && j == b - 1) {
            return 1;
        }

        if (t[i][j] != -1) return t[i][j];
        int choice1 = noOfUqPaths(a, b, i + 1, j);
        int choice2 = noOfUqPaths(a, b, i, j + 1);
        return t[i][j] = choice1 + choice2;
    }

    public int uniquePaths1(int m, int n) {
        return noOfUqPaths(m, n, 0, 0);
    }


    public static int noOfUqPathsBUP(int n, int m) {
        t = new int[n][m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 1;
                }
            }
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                t[i][j] = t[i - 1][j] + t[i][j - 1];
            }
        }


        return t[n - 1][m - 1];
    }


    //A3 -- Using nCr trick
    public static int nCr(int n, int r) {

        int[] C = new int[r + 1];
        C[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, r); j > 0; j--) {
                C[j] = (C[j] + C[j - 1]) % 2000000007;
            }
        }
        return C[r];

    }

    public int uniquePaths2(int m, int n) {

        return nCr(m + n - 2, n - 1);
    }

    public static void main(String[] args) {

    }
}
