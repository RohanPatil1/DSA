public class AllocatePagesofBooks {

    public static boolean isValid(int[] arr, int k, int mid) {
        boolean result = true;

        int sum = 0;
        int student = 1;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum > mid) {
                student++;
                sum = arr[i];

                // Now Check for no. of students
                if (student > k) {
                    return false;
                }
            }
        }

        return result;
    }

    public static int getMix(int[] arr, int k) {

        int result = -1;
        int n = arr.length;
        if (n < k) {
            return result;
        }
        /// Make a range of Max-Sum

        // Get Max & Sum of arr
        int max = 0, sum = 0;
        for (int x : arr) {
            sum += x;
            max = Math.max(max, x);
        }

        int start = max;
        int end = sum;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(arr, k, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getMix(new int[] { 10, 20, 5, 15, 5 }, 2));
    }
}
