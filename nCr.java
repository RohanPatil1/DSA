import java.util.*;

public class nCr {
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
        System.out.println(nCr(3, 2));
    }

}
