import java.util.*;

public class SubarrayswithKDifferentIntegers {
    public static void printArr(int[] arr, int i, int j) {
        for (int k = i; k <= j; k++) {
            System.out.print(arr[k] + " ");

        }
        System.out.println();
    }

    public static int subarraysWithKDistinct(int[] arr, int k) {
        int ans = 0;
        int n = arr.length;

        Map<Integer, Integer> map = new HashMap<>();

        int i = 0, j = 0;
        while (j < n) {
            // map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            if (map.containsKey(arr[j])) {
                map.put(arr[j], map.get(arr[j]) + 1);
            } else {
                map.put(arr[j], 1);
            }

            if (map.size() < k) {
                j++;
            } else if (map.size() == k) {
                ans++;
                printArr(arr, i, j);
                j++;
                

            } else if (map.size() > k) {
                while (map.size() > k) {
                    int currI = arr[i];
                    if (map.get(currI) == 1) {
                        map.remove(currI);
                    } else {
                        map.put(currI, map.get(currI) - 1);
                    }

                    i++;
                    if (map.size() == k) {
                        ans++;
                        printArr(arr, i, j);
                    }
                }
                j++;
            }

        }

        return ans;
    }

    public static void main(String[] args) {

        // System.out.println("Hellow");

        System.out.println(subarraysWithKDistinct(new int[] { 1, 2, 1, 2, 3 }, 2));

    }
}
