public class KthSmallestNumberInMultiplicationTable {
    //Time=> O(m*log(m*n))

    public int findKthNumber(int m, int n, int k) {

        int left = 1, right = m * n, mid;

        while (left < right) {

            mid = left + (right - left) / 2;

            if (doesHaveKSmallerNums(m, n, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        return left;
    }


    public boolean doesHaveKSmallerNums(int m, int n, int number, int numReqToBeSmall) {

        int count = 0;

        int currCount = 0;
        for (int row = 1; row < m + 1; row++) {

            currCount = Math.min(number / row, n);

            if (currCount == 0) break;  //No smaller here on will be found

            count += currCount;

        }


        return count >= numReqToBeSmall;
    }

}
