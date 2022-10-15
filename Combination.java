import java.util.ArrayList;
import java.util.List;

public class Combination {
    /*
    Why can't we put (start+1) instead of (i+1) while doing backtracking in generateSubset(start,n,current,subsets,k).
    I tried with start+1 and it gives solution with additional value of (1,1)(2,2)(3,3) for [1,2,3] and k=2 and n=3.
    Why the result is not same in both of the cases.




Ans: if you see the for loop then i is changing everytime but start will be same for all iterations,
 so it will give us extra members. If we pass start+1 then for every value of i in for loop it will send the same value,
  whereas if we pass i+1 then it is passing different number for every i.

     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultList = new ArrayList<>();


        List<Integer> currList = new ArrayList<>();

        solve(n, k, 1, currList, resultList);

        return resultList;
    }

    public void solve(int n, int k, int start, List<Integer> currList, List<List<Integer>> resultList){

        if(currList.size() == k){

            resultList.add(new ArrayList(currList));
            return;

        }

        System.out.println("Start: "+start);
        for(int i = start; i<=n; i++){
            System.out.println("i: "+i);
            currList.add(i);
            solve(n, k, i+1, currList, resultList );
            currList.remove(currList.size() - 1);
        }


    }
}
