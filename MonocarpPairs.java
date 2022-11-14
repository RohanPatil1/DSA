public class MonocarpPairs {


    public static int getPairCount(int[] arr) {

        int n = arr.length, count = 0, sum = 0;
        for (int num : arr) sum += num;

        int sum2 = sum - (2 * (sum / n));

        int targetSumOfPairs = sum - sum2;

        count = getPairCount(arr, targetSumOfPairs);
        return count;
    }

    public static int getPairCount(int[] arr, int target) {

        int count = 0;
        int n = arr.length;
        for (int j = n - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                int currSum = arr[j] + arr[i];
                if (currSum == target) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(getPairCount(new int[]{8, 8, 8, 8}));
        System.out.println(getPairCount(new int[]{50, 20, 10}));
        System.out.println(getPairCount(new int[]{1, 4, 7, 3, 5}));
        System.out.println(getPairCount(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

}
