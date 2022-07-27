import java.util.ArrayList;
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

        if (prev == -1 || arr[prev] < arr[i]) {
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


    static int lower_bound(ArrayList<Integer> arr, int key) {
        int[] array = new int[arr.size()];
        int p = 0;
        for (int i : arr) array[p++] = i;
        Arrays.sort(array);
        int index = Arrays.binarySearch(array, key);

        // If key is not present in the array
        if (index < 0) {

            // Index specify the position of the key
            // when inserted in the sorted array
            // so the element currently present at
            // this position will be the lower bound
            return Math.abs(index) - 1;
        }

        // If key is present in the array
        // we move leftwards to find its first occurrence
        else {

            // Decrement the index to find the first
            // occurrence of the key

            while (index > 0) {

                // If previous value is same
                if (array[index - 1] == key)
                    index--;

                    // Previous value is different which means
                    // current index is the first occurrence of
                    // the key
                else
                    return index;
            }

            return index;
        }
    }


    public static int lisNLogN(int[] arr, int n) {
        ArrayList<Integer> ansL = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            if (ansL.isEmpty()) {
                ansL.add(arr[i]);
                } else {
                int last = ansL.size() - 1;
                if (ansL.get(last) < arr[i]) {
                    ansL.add(arr[i]);
                    System.out.println(ansL);
                } else {
                    int x = lower_bound(ansL, arr[i]);
                    ansL.set(x, arr[i]);
                    System.out.println("LB"+ansL);
                }
            }
        }

        return ansL.size();
    }


    public static void main(String[] args) {
        System.out.println(lisItr(new int[]{4, 3, 9, 7, 6, 8, 20}, 7));
        System.out.println(lisDP(new int[]{4, 3, 9, 7, 6, 8, 20}, 7));
        System.out.println(lisNLogN(new int[]{0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15}, 16));
    }
}
