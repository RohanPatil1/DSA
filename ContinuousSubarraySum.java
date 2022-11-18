import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {


        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length;
        int currSum = 0, rem = 0;

        for (int i = 0; i < n; i++) {

            currSum += nums[i];

            rem = currSum % k;

            //From start we got, and len is atleast 2 i.e [0, 1 index]
            if (rem == 0 && i > 0) return true;

            if (map.containsKey(rem)) {

                int start = map.get(rem) + 1;
                int end = i;
                int currLen = end - start + 1;
                if (currLen >= 2) {
                    return true;
                }
            } else {
                map.put(rem, i);
            }
        }

        return false;
    }
}
