import java.util.*;

public class UniquePaths {

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

    public int uniquePaths(int m, int n) {

        return nCr(m + n - 2, n - 1);
    }

    public static void main(String[] args) {

    }
}
