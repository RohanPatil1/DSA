import java.util.*;

public class FirstLastOccuranceInArr {

        public static void getFirstOccur(int[] arr, int k) {

            int start = 0;
            int end = arr.length - 1;
            int result = -1;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] == k) {
                    // Got Ans
                    result = mid;
                    end = mid - 1;// To check for First occurance
                } else if (arr[mid] > k) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }
            System.out.println("First Occurance : " + result);
        }

        public static void getLastOccur(int[] arr, int k) {

            int start = 0;
            int end = arr.length - 1;
            int result = -1;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] == k) {
                    // Got Ans
                    result = mid;
                    start = mid + 1;// To check for Last occurance
                } else if (arr[mid] > k) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }
            System.out.println("Last Occurance : " + result);
        }

    public static void main(String[] args) {
        int k = 10;
        int[] arr = new int[] { 2, 4, 10, 10, 10, 18, 20 };
        getFirstOccur(arr, k);
        getLastOccur(arr, k);

    }
}
