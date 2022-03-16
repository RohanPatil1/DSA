import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
public class TwoSum {

    
    //2,7,11,15  (9)
    public static int[] twoSum(int[] arr,int sum){
        // int[] intArray = new int[]{}; 
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
           
            int complement = sum - arr[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(arr[i], i);
        }

            throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
        int[] argss = new int[]{2,7,11,15};
        int[] resultArr = twoSum(argss,9);
        System.out.println(Arrays.toString(resultArr));
    }



}
