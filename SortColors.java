import java.util.*;

public class SortColors {

    public static void printArr(int[] arr) {

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void sortColors(int[] nums) {

        int c0 = 0, c1 = 0, c2 = 0;
        for (int x : nums) {
            if (x == 0) {
                c0++;
            } else if (x == 1) {
                c1++;
            } else {
                c2++;
            }

        }
        int k = 0;
        for (int i = 1; i <= c0; i++) {
            nums[k++] = 0;
        }
        for (int i = 1; i <= c1; i++) {
            nums[k++] = 1;
        }

        for (int i = 1; i <= c2; i++) {
            nums[k++] = 2;
        }

    }

    public static void sortColors2(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int i = 0;
        while (i <= high) {
            if (arr[i] == 0) {
                int temp = arr[low];
                arr[low] = arr[i];
                arr[i] = temp;

                low++;
                i++;
            } else if (arr[i] == 2) {
                int temp = arr[i];
                arr[i] = arr[high];
                arr[high] = temp;
                high--;
            } else {
                //Its 1
                i++;
            }
        }

        printArr(arr);
    }

    public static void main(String[] args) {
      //  sortColors(new int[] { 2, 0, 2, 1, 1, 0 });
        sortColors2(new int[] { 2, 0, 2, 1, 1, 0 });

    }

}
