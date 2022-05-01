import java.util.*;

public class ForestBinarySearch {

    public static int calculateWood(int[] arr, int mid) {

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mid) {
                sum += (arr[i] - mid); // mid=15 arr[i]=20 wood collected is 20-15 = 5
            }
        }
        return sum;
    }

    public static int forestW(int[] arr, int k) {
        int start = 0, end = Integer.MIN_VALUE, mid = 0;

        // Get Max
        for (int i = 0; i < arr.length; i++) {
            end = Math.max(end, arr[i]);
        }

        while (start < end) {
            mid = start + (end - start) / 2;
            int currWood = calculateWood(arr, mid);
            if (currWood == k || start == mid) {
                return mid;
            } else if (currWood > k) {
                // We need less, go up
                start = mid;
            } else {
                // We need more, go down
                end = mid;
            }

        }
        return mid;

    }

    public static void main(String[] args) {
        System.out.println(forestW(new int[]{2,3,6,2,4}, 4));
    }
}
