import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
public class ThreeSum {


    public static List<List<Integer>> threeSum(int[] arr,int sum) {
        Set<List<Integer>> resultSet = new HashSet();
        Arrays.sort(arr);

        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            int curr = arr[i];
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                int currSum = curr + arr[start] + arr[end];
                if (currSum == sum) {
                    System.out.println("GOT SOMETHING");
                    List<Integer> tempL = new ArrayList<>();
                    tempL.add(arr[i]);
                    tempL.add(arr[start]);
                    tempL.add(arr[end]);
                    resultSet.add(tempL);
                    start++;
                    end--;
                } else if (currSum > 0) {
                    end--;
                } else {
                    start++;
                }

            }
        }

        return new ArrayList(resultSet);

    }
    public static boolean findTriplets(int arr[] , int n)
    {
        //add code here.
        Arrays.sort(arr);
        for(int i=0;i<arr.length-2;i++){
            int start = arr[i];
            int low = i+1;
            int high = arr.length-1;
            while(low<high){
                int sum = arr[low]+arr[high];
                int target = -start;
                if(sum == target){
                    return true;
                }else if(sum>target){
                    high--;
                }else{
                    low++;
                }
            }
        }
        
        return false;
        
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet();
        Arrays.sort(nums);
        //Logic: a+b+c = 0, a = -(b+c)

        
        for(int i=0; i<nums.length - 2; i++) {
            int a = nums[i];
            int low = i+1;
            int high = nums.length - 1;
            
            //Find other two numbers who's sum is equal to -a
            while(low<high) {
                int sum = nums[low] + nums[high];
                int target = -a;
                if(sum == target){
                    resultSet.add(Arrays.asList(a, nums[low], nums[high]));
                    low++;
                    high--;
                } else if(sum > target) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return new ArrayList(resultSet);
    }


    public static String reverseWord(String str)
    {
        // Reverse the string str

    String revStr = "";
    
        for(int i=str.length()-1;i>=0;i--){
            revStr += str.charAt(i);
        }


        return revStr;
    }
       

    public static void main(String[] args) {
    


       // int[] arr = new int[]{-1,0,1,2,-1,-4};
        int[] arr = new int[]{60 ,-65, 5, -21, 8, 93};

        List<List<Integer>> result = threeSum(arr);
        System.out.println(result.toString());

        System.out.println(findTriplets(arr,arr.length));

        String s = reverseWord("Geeks");
        System.out.println(s);
    }
}
