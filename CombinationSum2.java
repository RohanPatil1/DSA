import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> resultList = new ArrayList<>();


        List<Integer> currList = new ArrayList<>();
        Arrays.sort(candidates);


        solve(candidates, target, 0, currList, resultList);

        return resultList;
    }


    public void solve(int[] arr, int target, int index, List<Integer> currList, List<List<Integer>> resultList) {

        if (target == 0) {

            resultList.add(new ArrayList<>(currList));
            return;

        }

        if (target < 0) return;

        for (int i = index; i < arr.length; i++) {

            if (i > index && arr[i] == arr[i - 1]) continue;

            currList.add(arr[i]);
            solve(arr, target - arr[i], i + 1, currList, resultList);

            currList.remove(currList.size() - 1);

        }


    }
}
