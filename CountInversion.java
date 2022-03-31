
import java.util.*;

public class CountInversion {

    public static int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int invCount = 0;

        int i = left;
        int j = mid;
        int k = left;

        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // If Greater
                temp[k++] = arr[j++];
                // Add the count of elements to right of the mid as invCount
                invCount += mid - i;
            }
        }

        while (i <= mid - 1) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }

    public static int mergeSort(int[] arr, int[] temp, int left, int right) {
        int mid, invCount = 0;

        if (right > left) {
            mid = (right + left) / 2;

            invCount += mergeSort(arr, temp, left, mid);
            invCount += mergeSort(arr, temp, mid + 1, right);

            invCount += merge(arr, temp, left, mid + 1, right);

        }

        return invCount;
    }

    public static void main(String[] args) {
            int res = mergeSort(new int[]{8,4,2,1},new int[4],0,3);
            System.out.println(res);
    }
}
