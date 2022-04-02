
import java.util.*;

public class RotatedSortedArr {

    // Given Rotated Sorted array, Find the count it was rotated
    public static int getRotatedCount(int[] arr) {

        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        int n = arr.length;
        int prev, next;
        while (start <= end) {

            // Already Sorted
            if (arr[start] <= arr[end]) {
                return arr[start];
            }

            int mid = start + (end - start) / 2;
            next = (mid + 1) % n;
            prev = (mid + n - 1) % n;
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                // Got Ans
                result = mid;
                return result;

            } else if (arr[mid] >= arr[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        System.out.println(result);
        return result;
    }

    public static int binarySearch(int[] arr, int start, int end, int x) {
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return result;
    }

    // Given Rotated Sorted Array, Find a given element x
    public static int getElementInRSArr(int[] arr, int x) {
        int result = 0;

        int n = arr.length;

        int indexOfMin = getRotatedCount(arr);
        int res1 = binarySearch(arr, 0, indexOfMin - 1, x);
        int res2 = binarySearch(arr, indexOfMin, n - 1, x);
        if (res1 >= 0) {
            result = res1;
        } else if (res2 >= 0) {
            result = res2;
        } else {
            result = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 15, 18, 2, 3, 6, 12 };
        int res2 = getRotatedCount(arr);
        System.out.println(getElementInRSArr(arr, 18));
        // System.out.println(res2);

    }
}
