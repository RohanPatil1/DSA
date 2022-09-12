import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MEX {
    public static void printArr(int[] arr) {

        for(int x:arr){
            System.out.print(x+" ");
        }
        System.out.println();
    }

    //https://assets.leetcode.com/users/images/efc57c97-106f-4e12-a2fe-8415f101d937_1645815187.9360535.jpeg
    //https://leetcode.com/discuss/interview-question/1799446/mercari-inc-software-engineer-new-graduate-position-hiring-test-2022
    public static int getMEX(int[] arr, int x) {

        //Reduced all the elements to 0 to x-1
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];

            //4 3
            if (curr >= x) {
                while (curr >= (x - 1)) {
                    curr -= x;
                }
                arr[i] = curr;
            }

        }
        printArr(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int k : arr) {
            map.put(k, map.getOrDefault(k, 0) + 1);
        }

        //Get the least count
        int leastCountEntity = 0;
        int leastCount = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> k : map.entrySet()) {
            int count = k.getValue();
            if (leastCount > count) {
                leastCountEntity = k.getKey();
                leastCount = count;
            }
        }
        int MEX = leastCountEntity + leastCount * x;
        return MEX;
    }

    public static void main(String[] args) {
        System.out.println(getMEX(new int[]{0, 1, 2, 1, 3}, 3));
    }

}
