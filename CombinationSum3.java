import java.util.ArrayList;
import java.util.List;
public class CombinationSum3 {


    public List<List<Integer>> combinationSum3(int k, int n) {

        //Given list is [1,...,9]
        //Find subset with 'k' size which has 'n' sum
        List<List<Integer>> resultList = new ArrayList<>();

        List<Integer> currList = new ArrayList<>();


        solve(1, 9, n, k, currList, resultList);

        return resultList;

    }

    public void solve(int start, int end, int target, int k,List<Integer> currList, List<List<Integer>> resultList){

        if(target == 0 && currList.size() == k){
            resultList.add(new ArrayList<>(currList));
            return;
        }


        for(int i = start; i<=end; i++){
            currList.add(i);

            solve(i+1, end, target - i, k, currList, resultList);

            currList.remove(currList.size() - 1);

        }



    }



}
