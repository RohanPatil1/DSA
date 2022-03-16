import java.util.*;

public class SubSumArray {

    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // Arrays.sort(arr);
        // Your code here

        int start = 0;
        int end = -1;
        int currSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            currSum += arr[i];

            if (currSum - s == 0) {
                start = 0;
                end = i;
                result.add(start + 1);
                result.add(end + 1);
                return result;
            }

            if (map.containsKey(currSum - s)) {
                start = map.get(currSum - s) + 1;
                end = i;
                result.add(start + 1);
                result.add(end + 1);
                return result;
            }

            map.put(currSum, i);

        }

        if (end == -1) {
            result.add(-1);
            return result;

        }

        return result;

    }

    // Find the largest subArray with equal no. of 1s and 0s
    public static ArrayList<Integer> getSubsWithEqual(int[] arr, int n) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        int start = 0;
        int end = -1;
        int currSum = 0;
        int max = 0;
        // Put all 0 to -1
        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            currSum += arr[i];

            if (currSum == 0) {
                max = i + 1;
            }

            if (map.containsKey(currSum)) {
                int len = i - map.get(currSum);
                if (len > max) {
                    max = len;
                    result.clear();
                    result.add(map.get(currSum)+1);
                     result.add(i);
                }
            } else {
                map.put(currSum, i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
         int[] arr = new int[] { 1, 2, 3, 7, 4 };
        // int[] arr = new int[]{135, 101, 170, 125, 79, 159, 163, 65 ,106, 146, 82 ,28,
        // 162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93 ,183 ,22 ,117, 119, 96 ,48
        // ,127, 172, 139, 70, 113, 68, 100 ,36 ,95, 104, 12, 123, 134};

        ArrayList<Integer> result = new ArrayList<Integer>();

        // System.out.println("aasdsdsafd");
        // result= subarraySum(arr,42 ,468);
       result = subarraySum(arr, 5, 12);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");

        }
        System.out.println("------------------------------");

        // int[] arr = new int[] {1,1,0,1,1,0,0};
        // int arr[] = { 1, 0, 0, 1, 0, 1, 1 };
        // int[] arr = new int[] {1,1,-1,1,1,-1,-1};

       // int arr[] = { 1, 0, 0, 1, 0, 1, 1 };
        // getSubsWithEqual(arr,7,0);

   //     result = getSubsWithEqual(arr, 7);

    //    for (int i = 0; i < result.size(); i++) {
   //         System.out.print(result.get(i) + " ");

   //     }

    }

}
