import java.util.*;


public class uber1 {

    // Minimum Number of operation to make array continuous

    public static int getMinOp(int[] arr, int size) {
        int count = 0;
        // int size = arr.length;
        // int[] targetArr = new int[size];
        // targetArr[0] = arr[0];
        // for(int i=1;i<arr.length;i++){
        // targetArr[i] += 1;
        // }

        // { ActualValue, TargetValue }
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap();
        map.put(arr[0], arr[0]);

        for (int i = 1; i < size; i++) {
            map.put(arr[i], arr[0] + i);
        }

        var targetArr = map.values();
        var f = targetArr.toArray();
        // int[] targetArr = map.values();
        for (int i = 0; i < size; i++) {
            if (!map.containsKey(f[i])) {
                count++;
            }

        }
        return count;
    }

    public static int getMinOpp(int[] arr) {

        int size =  arr.length;
        // Sort and remove duplicates
        Arrays.sort(arr);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length-1; i++) {
            set.add(arr[i]);
        }
      

        // Create a sliding window and get the Max array with continuous elements so
        // result will be length - max
        int end = 0; // We will expand our window
        int max = 0;
        int temp = 0;
        for (int start = 0; start <arr.length; start++) {
            // Take a start and find a continous with this start
            temp = arr[start]+size;
            while (arr[end] < temp && end < arr.length-1) {
                end += 1;
            }
            int count = end - start;
            max = Math.max(max, count);
        }
        return size - max;
    }

    // 4 5 7 9 11
    public static void main(String[] args) {

        int[] arr = new int[] { 4, 7, 11, 6, 9 };
        // int[] arr = new int[] { 1,10,100,1000 };
        int result = getMinOpp(arr);
        System.out.println(result);

    }

}
