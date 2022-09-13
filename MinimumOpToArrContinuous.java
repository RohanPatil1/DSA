import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumOpToArrContinuous {


    public void removeDupl(int[] arr) {

        int end = arr.length;
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < end; i++) {
            set.add(arr[i]);
        }


        int[] res = new int[set.size()];
        int k = 0;

        for (Integer v : set) {
            res[k++] = v;
        }

    }

    public int minOperations(int[] nums) {

        int n = nums.length;

        removeDupl(nums);
        Arrays.sort(nums);


        int m = nums.length;
        int res = n;
        int end = 0;
        for (int start = 0; start < m; start++) {
            while (end < m && nums[end] <= nums[start] + n - 1) {
                end++;//Counter of numbers that are in expected continuous
            }
            //end - start = Total count of numbers as continuous
            //n- (end-start) = Not continuous = NEED Op
            res = Math.min(res, n - (end - start));
        }
        return res;


    }
}
