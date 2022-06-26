public class MinimumHeight {


    public static int minimumHeight(int[] arr, int k) {

        int n = arr.length;

        int ans = arr[n - 1] - arr[0];

        for (int i = 1; i < n; i++) {

            int start = Math.min(arr[0] + k, arr[i] - k);
            int end = Math.max(arr[i - 1] + k, arr[n - 1] - k);


            if (start < 0) {
                continue;
            }
            ans = Math.min(ans, end - start);
        }


        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimumHeight(new int[]{3, 9, 12, 16, 20}, 2));
    }

}
