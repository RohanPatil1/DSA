
import java.util.*;

public class CountReversePairs {

    public static int merge(int[] arr, int low, int mid, int high) {
        int count = 0;
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && arr[i] > (2 * (long) arr[j])) {
                j++;
            }
            count += (j - (mid + 1));
        }

        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left++]);
            } else {
                temp.add(arr[right++]);
            }
        }

        while (left <= mid) {
            temp.add(arr[left++]);
        }
        while (right <= high) {
            temp.add(arr[right++]);
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i-low);
        }

        return count;
    }

    public static int mergeSort(int[] arr, int low, int high) {

        if (low >= high)
            return 0;

        int mid = (low + high) / 2;
        int count = mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);

        return count;
    }

    public static void main(String[] args) {
        int res = mergeSort(new int[] {1,3,2,3,1},0,4);
        System.out.println(res);
    }
}
