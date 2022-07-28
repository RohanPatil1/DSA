import java.util.*;

public class nCr {

    //nCr = n-1Cr-1 + n-1Cr
    public static int nCrA1(int n, int r) {
        if (n == r || r == 0) return 1;

        int ans1 = nCrA1(n - 1, r - 1);
        int ans2 = nCrA1(n - 1, r);
        return ans1 + ans2;
    }




    static int nCr(int n, int r) {

        int[] C = new int[r + 1];
        C[0] = 1;

        for (int i = 1; i <= n; i++) {

            for (int j = Math.min(i, r); j > 0; j--) {
                C[j] = (C[j] + C[j - 1]) % 1000000007;
            }

        }
        return C[r];
    }

    public static void main(String[] args) {
        System.out.println(nCr(9, 3));
        System.out.println(nCrA1(9, 3));
    }

}
