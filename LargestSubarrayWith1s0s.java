import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWith1s0s {

    int maxLen(int[] arr, int N) {
        // Your code here

        int max = 0;
        int currSum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        //Put all 0 to -1
        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) arr[i] = -1;
        }


        for (int i = 0; i < N; i++) {
            currSum += arr[i];
            if (currSum == 0) max = i + 1;

            if (map.containsKey(currSum)) {
                int len = i - map.get(currSum);
                max = Math.max(max, len);
            } else {
                map.put(currSum, i);
            }
        }
        return max;

    }

}
