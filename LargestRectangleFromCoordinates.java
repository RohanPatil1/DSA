import java.util.*;

public class LargestRectangleFromCoordinates {

    public static int largestArea(int[] arr1, int n, int[] arr2, int m) {
        int result = 0;

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0, start = 0;
        int j = 0, end = 0;

        while (i < n && j < m) {

            if (arr1[i] == arr2[j]) {
                if (start == 0) {
                    start = arr1[i];
                } else {
                    end = arr1[i];
                }
                j++;
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                i++;
            }

        }
        if (end == 0 || start == 0)
            return 0;
        else
            // Return the area
            return (end - start);

    }

    public static void main(String[] args) {

        int arr1[] = { 1, 2, 4 };

        // Given length
        int N = arr1.length;

        // Given points
        int arr2[] = { 1, 3, 4 };

        // Given length
        int M = arr2.length;

        // Function Call
        System.out.println(largestArea(arr1, N, arr2, M));

    }

}
