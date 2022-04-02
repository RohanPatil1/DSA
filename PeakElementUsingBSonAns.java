
import java.util.*;

public class PeakElementUsingBSonAns {

    public static int getPeak(int[] arr) {
        int result = 0;
        int start = 0;
        int end = arr.length - 1;
        int n = arr.length;
        while (start <= end) {

            int mid = start + (end - start) / 2;
            if (mid > 0 && mid < n - 1) {
                // Elements with definte neighbours
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    // Got Peak Element
                    return mid;
                } else if (arr[mid - 1] > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (mid == 0) {
                if (arr[0] > arr[1]) {
                    return 0;
                } else {
                    return 1;
                }
            } else if (mid == n - 1) {
                if (arr[n - 2] < arr[n - 1]) {
                    return n - 1;
                } else {
                    return n - 2;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3 };
        System.out.println(getPeak(arr));
    }

}
