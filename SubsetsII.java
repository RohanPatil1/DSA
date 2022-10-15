import java.util.*;

public class SubsetsII {


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> setList = new HashSet<>();


        List<Integer> currList = new ArrayList<>();

        solve(nums, 0, currList, setList);


        return new ArrayList<>(setList);
    }

    public void solve(int[] nums, int index, List<Integer> currList, Set<List<Integer>> setList) {


        if (index == nums.length) {
            List<Integer> list = new ArrayList<>(currList);
            Collections.sort(list);
            setList.add(list);
            return;
        }


        //Include
        currList.add(nums[index]);
        solve(nums, index + 1, currList, setList);

        //Not Include
        currList.remove(currList.size() - 1);
        solve(nums, index + 1, currList, setList);

    }

    //Skips duplicates  & requires nums to be sorted!
    public void solve2(int[] nums, int index, List<Integer> currList, Set<List<Integer>> setList){

        if(index == nums.length){
            List<Integer> list = new ArrayList<>(currList);
            setList.add(list);
            return;
        }


        //Include
        currList.add(nums[index]);
        solve2(nums, index + 1, currList, setList);

        //Not Include
        currList.remove(currList.size() - 1);

        //Skip duplicates
        while(index + 1 < nums.length && nums[index] == nums[index+1]){
            index +=1;
        }

        solve2(nums, index + 1, currList, setList);

    }


    //Best
    public void solve3(int[] nums, int index, List<Integer> currList, List<List<Integer>> resultList){

        resultList.add(new ArrayList<>(currList));

        for(int i=index; i<nums.length; i++){

            //if not first && prev is same as current
            if(i > index && nums[i] == nums[i-1]) continue;

            currList.add(nums[i]);
            solve3(nums, i+1, currList, resultList);

            currList.remove(currList.size() - 1);
        }


    }


}
