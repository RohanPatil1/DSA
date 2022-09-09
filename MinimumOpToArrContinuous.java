import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
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
        int j = 0;
        for(int i=0; i<m; i++){
            while(j<m && nums[j]<=nums[i]+n-1) j++;
            res = Math.min(res, n-(j-i));
        }
        return res;


    }
}
