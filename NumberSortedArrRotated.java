public class NumberSortedArrRotated {


    public static int timesRotated(int[] arr) {

        int n = arr.length;
        int ansCount = 0;
        int start = 0;
        int end = n - 1;
        int mid = 0, prev = 0, next = 0;
        while (start <= end) {
            prev = (mid + 1) % n;
            next = (mid + n - 1) % n;

            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
                return mid;
            } else if (arr[mid] >= arr[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        return ansCount;
    }
}
