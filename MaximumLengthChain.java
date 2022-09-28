import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthChain {

//https://leetcode.com/problems/maximum-length-of-pair-chain/discuss/745935/Java-Solution-%3A-Recursion-%2B-memoziation...!!!

    public class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

    }

    class CompareBySecond implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return a.b - b.b;
        }
    }

    int[] t = new int[1001];

    public int findLongestChain(int[][] pairs) {

        int n = pairs.length;
        int m = pairs[0].length;

        Pair[] pairsArr = new Pair[n];

        int k = 0;
        for (int[] arr : pairs) {
            pairsArr[k++] = new Pair(arr[0], arr[1]);
        }

        Arrays.fill(t, -1);
        Arrays.sort(pairsArr, new CompareBySecond());
        return solve(pairsArr, 0, Integer.MIN_VALUE);
    }

    private int solve(Pair[] pairsArr, int i, int prevValue) {
        if (i >= pairsArr.length) {
            return 0;
        }

        if (t[i] != -1) {
            return t[i];
        }

        int choice1 = 0, choice2 = 0;
        if (pairsArr[i].a > prevValue) {
            choice1 = 1 + solve(pairsArr, i + 1, pairsArr[i].b);
        }
        choice2 = solve(pairsArr, i + 1, prevValue);

        return t[i] = Math.max(choice1, choice2);
    }

}
