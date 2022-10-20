public class CheckforMajorityElementSortedArray {

    static boolean isMajority(int arr[], int n, int x) {

        int left = lmiBS(arr, x);
        int right = lmiBS(arr, x + 1);

        int windowSize = right - left + 1;
        if (windowSize > n / 2) {
            return true;
        }
        return false;
    }

    public static int lmiBS(int[] arr, int target) {

        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) left = mid + 1;
            else right = mid;
        }

        return left;
    }

}
