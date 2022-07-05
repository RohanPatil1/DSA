import java.util.ArrayList;
import java.util.Collections;

public class SubsetSums {


    void subsetSumHelper(ArrayList<Integer> arr, int n, int index, int sum, ArrayList<Integer> sumSubset) {
        if(index==n){
            sumSubset.add(sum);
            return;
        }

        //Pick
        subsetSumHelper(arr,n,index+1,sum+ arr.get(index),sumSubset);

        //Not pick
        subsetSumHelper(arr,n,index+1,sum,sumSubset);
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        // code here

        ArrayList<Integer> subSum = new ArrayList<>();
        subsetSumHelper(arr, N, 0, 0, subSum);
        Collections.sort(subSum);
        return subSum;
    }


    public static void main(String[] args) {

    }

}
