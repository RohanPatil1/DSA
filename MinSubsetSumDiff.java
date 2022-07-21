public class MinSubsetSumDiff {


    public static int minSubsetSum(int[] arr, int n) {

        int tSum = 0;
        for (int a : arr) tSum += a;

        int sum = tSum / 2;
        boolean[][] t = new boolean[1001][1001];

        //init
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) t[i][j] = false;
                if (j == 0) t[i][j] = true;
            }
        }

        //Fill the rest with ans
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        //Start from back &get the first true entry
        int S1 = 0, S2 = 0;
        for (int i = sum; i >= 0; i++) {
            if (t[n][i]) {
                S1 = i;
                break;
            }
        }
        S2 = tSum - S1;

        return Math.abs(S1 - S2);
    }

    public static void main(String[] args) {

    }


}
