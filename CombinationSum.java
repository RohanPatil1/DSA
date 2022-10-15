import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> sumList = new ArrayList<>();

        List<Integer> currList = new ArrayList<>();

        solve(candidates, currList, 0, 0, sumList, target);

        return sumList;

    }


    public void solve(int[] arr, List<Integer> currList, int i,int currSum, List<List<Integer>> sumList, int target){



        if(currSum > target) return;

        if(currSum == target){

            List<Integer> list = new ArrayList<>(currList);
            sumList.add(list);
            return;
        }

        if(i==arr.length) return;

        //Include
        currList.add(arr[i]);
        solve(arr, currList, i ,currSum + arr[i], sumList, target);

        //Not Include
        currList.remove(currList.size() - 1);
        solve(arr, currList, i+1, currSum, sumList, target);

    }


    public void solve2(int[] arr, List<Integer> currList, int start, List<List<Integer>> sumList, int target){


        if(target == 0){
            sumList.add(new ArrayList<>(currList));
            return;
        }

        if(target < 0){
            return;
        }


        for(int i=start; i<arr.length; i++){

            currList.add(arr[i]);
            solve2(arr, currList, i, sumList, target - arr[i]);

            currList.remove(currList.size()-1);

        }



    }
}
