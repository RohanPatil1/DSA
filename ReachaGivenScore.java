import java.util.Arrays;

public class ReachaGivenScore {

    static final int[] score = new int[]{3, 5, 10};
    static long[][] t = new long[3][1001];

    public static long countScore(int i, long n) {
        if (n == 0) return 1;
        if (i == 3 || n < 0) return 0;

        long ans1 = countScore(i, n - score[i]);
        long ans2 = countScore(i + 1, n);
        return ans1 + ans2;
    }


    public static long countScore2(int i,int n) {
        if (n == 0) return 1;
        if (i == 3 || n < 0) return 0;

        if(t[i][n]!=-1) return t[i][n];
        long ans1 = countScore(i, n - score[i]);
        long ans2 = countScore(i + 1, n);
        return t[i][n]=ans1 + ans2;

    }


    public static void main(String[] args) {
        for (long[] arr : t) {
            Arrays.fill(arr, -1);
        }
        System.out.println(countScore(0, 435));
        System.out.println(countScore2(0, 435));
    }
}
