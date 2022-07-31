import java.util.Arrays;

public class ReachAGivenScore {
    public static void printLongMatrix(long[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        System.out.println(" ");

    }

    static final int[] score = new int[]{3, 5, 10};
    static long[][] t = new long[3][1001];

    public static long countScore(int i, long n) {
        if (n == 0) return 1;
        if (i == 3 || n < 0) return 0;

        long ans1 = countScore(i, n - score[i]);
        long ans2 = countScore(i + 1, n);
        return ans1 + ans2;
    }

    //BUP
    public static long countScoreBUP(int n) {
        //Init
        t = new long[4][n + 1];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0) t[i][j] = 0;
                if (j == 0) t[i][j] = 1;
            }
        }


        //Fill the rest with ans
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < n + 1; j++) {

                t[i][j] = t[i - 1][j];
                if (j >= score[i - 1]) t[i][j] += t[i][j - score[i - 1]];
            }
//            printLongMatrix(t);

        }


        return t[3][n];
    }

    //A3  dp[i] = d[i] + d[i-d];
    public static long countScore3(int n) {
        int[] t = new int[n + 1];
        t[0] = 1;
        t[1] = 0;
        t[2] = 0;

        for (int i = 3; i <= n; i++)
            t[i] += t[i - 3];

        for (int i = 5; i <= n; i++)
            t[i] += t[i - 5];

        for (int i = 10; i <= n; i++)
            t[i] += t[i - 10];

        return t[n];
    }


    public static void main(String[] args) {
        for (long[] arr : t) {
            Arrays.fill(arr, -1);
        }
        System.out.println(countScore(0, 10));
        System.out.println(countScoreBUP(10));
        System.out.println(countScore3(10));
    }
}
