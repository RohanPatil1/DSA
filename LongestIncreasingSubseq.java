import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


    static int ceil(int key, List<Integer> lst){
        int low = 0 , high = lst.size() - 1;
        int ans = -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            int val = lst.get(mid);
            if(val == key) return mid;
            else if(val < key) low = mid + 1;
            else{
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
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
                    int x = ceil( arr[i],ansL);
                    ansL.set(x, arr[i]);
                    System.out.println("LB" + ansL);
                }
            }
        }

        return ansL.size();
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int size = 0;

        for(int num: nums) {
            // binary search
            int left = 0, right = size, middle = 0;     // right = size
            while(left < right) {
                middle = left + (right - left) / 2;
                if(dp[middle] < num) left = middle + 1;
                else right = middle;
            }

            // left is the right position to 'replace' in dp array
            dp[left] = num;
            if(left == size) size++;
        }
        return size;
    }


    public static void main(String[] args) {
        System.out.println(lisItr(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}, 16));
        System.out.println(lisDP(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}, 16));
        System.out.println(lisNLogN(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}, 16));
    }
}
