import java.util.HashMap;
import java.util.Map;

public class NumberOfSubarraysDivisibleByK {

    public int subarraysDivByK(int[] nums, int k) {

        //Remainder, Freq
        Map<Integer, Integer> map = new HashMap<>();

        int currSum = 0;
        int count = 0, rem = 0;
        map.put(0, 1);

        for (int num : nums) {
            currSum += num;
            rem = currSum % k;

            //When rem becomes -ve, just add +k in it
            if (rem < 0) rem += k;

            if (map.containsKey(rem)) {
                count += map.get(rem);
                map.put(rem, map.get(rem) + 1);
            } else {
                map.put(rem, 1);

            }

        }


        return count;
    }
//Next Ques : Continuous Subarray Sum
}
