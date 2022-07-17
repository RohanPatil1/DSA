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
        int start = 0, end = 0, mid = 0;

        Arrays.sort(arr);
        end = arr[arr.length-1];
        while (start <= end) {
            mid = start + (end - start) / 2;
            int currWood = calculateWood(arr, mid);
            if (currWood == k ) {
                //System.out.println("CurrWood: "+currWood+"  k: "+k);
                return mid;
            } else if (currWood > k) {
                // We need less, go up
                start = mid+1;
            } else {
                // We need more, go down
                end = mid-1;
            }

        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(forestW(new int[]{56, 75, 89, 20, 99}, 59));
    }
}
