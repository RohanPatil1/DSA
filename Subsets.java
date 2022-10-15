import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {


    public List<List<Integer>> subsetsITR(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        resList.add(new ArrayList<>());

        /*
            1=>[] , [1]
            2=>[]+2=[2], [1]+1 = [1,2] ===>[], [1], [2], [1,2]
            3=>[]+3=[3], [1]+3 = [1,3], [2]+3= [2,3], [1,2]+3=[1,2,3] =>[], [1], [2], [1,2],[3], [2,3], [1,2,3]
        */

        for (int num : nums) { //T=n
            int n = resList.size();
            for (int j = 0; j < nums.length; j++) {//T=2^n size[][]..
                List<Integer> currList = new ArrayList<>(resList.get(j)); //deepCopy
                currList.add(num);
                resList.add(currList);
            }

        }
        return resList;

        //Time=O(n*2^n)
        //Space=O(n*2^n)
    }


    public List<List<Integer>> subsetsBT(int[] nums) {
        Set<List<Integer>> setList = new HashSet<>();

        List<Integer> currList = new ArrayList<>();
        solve(nums, 0, currList, setList);

        return new ArrayList(setList);

    }

    public void solve(int[] nums, int i, List<Integer> currList, Set<List<Integer>> setList) {

        if (i == nums.length) {
            List<Integer> list = new ArrayList<>(currList);
            setList.add(list);
            return;
        }

        //Include
        currList.add(nums[i]);
        solve(nums, i + 1, currList, setList);

        //Not Include
        currList.remove(currList.size() - 1);
        solve(nums, i + 1, currList, setList);

    }

    public void solve2(int[] nums, int index, List<Integer> currList, Set<List<Integer>> setList) {

        currList.add(nums[index]);//[]

        for (int i = index; i < nums.length; i++) {
            currList.add(nums[i]);//[1]
            solve2(nums, i + 1, currList, setList);//---------------go deep [], [1]
            currList.remove(currList.size() - 1);//[]
        }

    }


}
