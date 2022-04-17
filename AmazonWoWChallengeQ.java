import java.util.*;

public class AmazonWoWChallengeQ {

    static boolean isPrime(int n) {

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int[] getPrimeArr(int n) {
        int[] primeArr = new int[n + 1];

        // int m=n;//3
        // while(m!=0){
        // for(int i=2;i<=n;i++){

        // }
        // }

        return primeArr;
    }

    public static int getMinCount(int[] arr, int w, int n) {

        int[][] t = new int[n + 1][w + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0) {
                    t[i][j] = Integer.MAX_VALUE - 1;
                }
                if (j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = Math.min(t[i][j - arr[i - 1]] + 1, t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][w];
    }

    public static int solve(int d, int k) {
        int ans = 0;

        // int[] primes = getPrimeArr(k);
        // System.out.println(primes.toString());
        int count = getMinCount(new int[] { 2, 3, 5 }, 11, 3);
        System.out.println(count);
        return ans;
    }

    public static void main(String[] args) {
        solve(10, 1);
    }
}
