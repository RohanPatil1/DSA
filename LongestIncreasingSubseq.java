public class LongestIncreasingSubseq {


    public static int lis(int[] input, int n) {
        int ans = Integer.MIN_VALUE;
        int[] t = new int[n];

        for (int i = 0; i < n; i++) {
            t[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (input[j] > input[i]) continue;

                int tempAns = t[j] + 1;
                if (tempAns > t[i]) t[i] = tempAns;
            }
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, t[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lis(new int[]{4, 3, 9, 7, 6, 8, 20}, 7));
    }
}
