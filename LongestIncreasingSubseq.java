import java.util.Arrays;

public class LongestIncreasingSubseq {


    public static int lisItr(int[] input, int n) {
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

    //We can also make this t[prev] and store the overall min for this prev...SpaceCompl will be then O(N)
    static int[][] t = new int[10001][10001];

    public static int recursion(int[] arr, int n, int i, int prev) {
        if (i >= n) return 0;

        if (t[prev + 1][i] != -1) return t[prev + 1][i];

        if (prev == -1 ||  arr[prev] < arr[i]) {
            int ans1 = 1 + recursion(arr, n, i + 1, i);
            int ans2 = recursion(arr, n, i + 1, prev);
            return t[prev + 1][i] = Math.max(ans1, ans2);
        } else {
            return t[prev + 1][i] = recursion(arr, n, i + 1, prev);
        }
    }

    public static int lisDP(int[] arr, int n) {
        for (int[] num : t) Arrays.fill(num, -1);
        return recursion(arr, n, 0, -1);
    }


    public static void main(String[] args) {
        System.out.println(lisItr(new int[]{4, 3, 9, 7, 6, 8, 20}, 7));
        System.out.println(lisDP(new int[]{4, 3, 9, 7, 6, 8, 20}, 7));
    }
}
