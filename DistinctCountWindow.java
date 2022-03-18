import java.util.*;

public class DistinctCountWindow {

    //Get Distinct elements in specific window
    public static void getDis(int[] arr, int k) {
        int n = arr.length;

        Map<Integer, Integer> map = new HashMap<>(n);
        // Add first 4 into map
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.print(map.size() + " ");

        // Handle the rest
        for (int j = k; j < n; j++) {

            // Remove the previous element count for the next window
            // And add the new element arr[j] in map
            if (arr[j - k] == 1) {
                map.remove(arr[j]);
            } else {
                map.put(arr[j - k], map.getOrDefault(arr[j - k], 0) - 1);
            }
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            System.out.print(map.size() + " ");
        }

    }

    // Count distinct pairs with difference k
    public static int TotalPairs(int[] nums, int k)
    {
        // Code here
        Set<List<Integer>> result =new HashSet<>();
    //    int currDiff=0;
        int n=nums.length;
        
        
        for(int i=0;i<n;i++){
            int start = nums[i];
            int j=i+1;
            while(j<n){
                int currDiff = nums[j] - start;
                if(currDiff==k){
                    result.add(Arrays.asList(nums[j],nums[i]));
                }
                j++;
            }
        
        }
        
        // List<Integer> s = set
        // for(){

        // }

        return result.size();
    }

    public static void main(String[] args) {

        int[] arr = {11, 6, 10, 5, 11, 16};
        int res2= TotalPairs(arr,5);
        System.out.println(res2);
        System.out.println("HASLJD");
    }
}
