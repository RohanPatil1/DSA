
import java.util.*;

public class FindElementInfiniteArr {

    public static int getElementINFarr(int[] arr, int x) {
        int result = 0;

        int start = 0;
        int end = 1;
        while (arr[end] < x) {
            start = end;
            end *= 2;
        }

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

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 8 };
        System.out.println(getElementINFarr(arr, 5));
    }

}
