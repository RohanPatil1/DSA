import java.util.*;
public class ZeroSumSubarray {
    

    public static int zeroSumArr(int[] arr) {
        int ans =0;
        int n =arr.length;
        HashMap<Integer,Integer> map =new HashMap<>();

        int sum = 0;
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum += arr[i];
            map.put(sum,map.getOrDefault(sum, 0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int curr = entry.getValue();
            ans += (curr)*(curr-1)/2;
        }

        return ans;

    }
public static void main(String[] args) {
 
    System.out.println(zeroSumArr(new int[]{0,0,5,5,0,0}));
}


}
