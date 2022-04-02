import java.util.*;

public class BinarySearchInNearySortedArr {

    // NearySorted Arr means the correct(in sorted arr) position of the element will
    // be i-1,i or i+1
    public static int getElementInNSArr(int[] arr, int x) {
        int result = -1;
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if ((mid - 1) >= start && arr[mid - 1] == x) {
                return mid - 1;
            } else if ((mid + 1) <= end && arr[mid + 1] == x) {
                return mid + 1;
            } else if (arr[mid] >= x) {
                end = mid - 2;
            } else {
                start = mid + 2;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 10, 3, 40, 20, 50, 80, 70 };
        System.out.println(getElementInNSArr(arr, 40));
    }

}
