import java.util.*;

public class LargestLenSubArrayOfSumK {

    public static int getMaxLen(int[] arr, int k) {
        int result = Integer.MIN_VALUE;

        int i = 0;
        int j = 0;
        int n = arr.length;
        int sum = 0;
        while (j < n) {
            sum += arr[j];

            // Window sum checks
            if (sum < k) {
                j++;
            } else if (sum == k) {
                // Condn Matched, get answer
                result = Math.max(result, j - i + 1);
                j++;
            } else {
                // sum>k
                // Remove elements from i until sum becomes less than or equal to k
                while (sum > k) {
                    sum -= arr[i];
                    i++;
                }
                j++;
            }

        }
        return result;
    }

    // For negative numbers
    // Using DP
    public static int getMaxLen2(int[] arr, int k) {
        int result = Integer.MIN_VALUE;

        int i = 0;
        int n = arr.length;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(n);
        for (i = 0; i < n; i++) {
            sum += arr[i];

            // if currSum is not in map
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            /*
             * if the sum is not equal to the sum asked we can search for the sum "k-sum"
             * in the map. If that is present in the map then that means the remaining part
             * will be k . Eg : if the sum given is 3 in an array [1,2,3]
             * Then sum upto three will be 6, but I want 3. So I will search if the sum 6-3
             * was found before . If it was found then the remaining part will be the sum
             * requested in this case 3.
             */
            if (map.containsKey(sum - k)) {
                result = Math.max(result, i - map.get(sum - k));
            }

            // if the sum being calculated is equal to the sum asked
            if (sum == k) {
                result = Math.max(result, i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 3, 3, 5, 5 };
        int res = getMaxLen(arr, 16);
        int res2 = getMaxLen2(arr, 16);
        System.out.println(res);

        System.out.println(res2);
    }
}
