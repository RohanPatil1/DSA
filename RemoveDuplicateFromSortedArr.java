import java.util.*;

public class RemoveDuplicateFromSortedArr {

    ///O(n)
    public static int getUniqLen(int[] arr) {
        int n = arr.length;
        int result = 0;

        int i = 0;
        for (int j = 1; j < n; j++) {
            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }

        result = i+1;
        return result;

    }

    public static void main(String[] args) {

    }
}
