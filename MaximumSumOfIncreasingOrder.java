public class MaximumSumOfIncreasingOrder {


    // Function for finding maximum and value pair
    public static int maximumSum(int n, int m, int arr[][]) {
        //Complete the function

        int limit = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {

            int maxS = -1;
            for (int j = 0; j < m; j++) {

                if (arr[i][j] < limit) {
                    maxS = Math.max(maxS, arr[i][j]);
                }
            }
            if (maxS == -1) {
                return 0;
            }

            limit = maxS;
            sum += maxS;


        }

        return sum;


    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 7, 4, 3}, {4, 2, 5, 1}, {9, 5, 1, 8}};
        System.out.println(maximumSum(arr.length,arr[0].length,arr));;
    }
}
