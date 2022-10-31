import java.util.ArrayList;
import java.util.List;

public class Permutation {


    /*
    Time Complexity:  N! x N

    Space Complexity:  O(N)
     */
    public List<List<Integer>> permute(int[] nums) {

        int n = nums.length;
        List<List<Integer>> permutationList = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        boolean[] flags = new boolean[n];
        solve(nums, currList, flags, permutationList);

        return permutationList;
    }

    private void solve(int[] nums, List<Integer> currList, boolean[] flags, List<List<Integer>> permutationList) {
        if (currList.size() == nums.length) {
            List<Integer> list = new ArrayList<>(currList);
            permutationList.add(list);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!flags[i]) {
                flags[i] = true;
                currList.add(nums[i]);
                solve(nums, currList, flags, permutationList);
                currList.remove(currList.size() - 1);
                flags[i] = false;
            }
        }

    }
//Time=>O(N! * n)
    private void solve2(int[] nums, List<Integer> currList, int index, List<List<Integer>> permutationList) {
        if (index == nums.length) {
            List < Integer > list = new ArrayList < > ();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            permutationList.add(list);
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            swap(nums, i, index);
            solve2(nums, currList, index + 1, permutationList);
            swap(nums, i, index);

        }

    }

    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
