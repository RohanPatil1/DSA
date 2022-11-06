public class KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        //Binary search with doesHaveKSmallerNums feature

        int n = matrix.length;

        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        int mid = 0;

        while(left < right){

            mid = left + (right - left)/2;

            if(doesHaveKSmallerNums(matrix, k, mid)){
                right = mid;
            }else{
                left = mid + 1;
            }

        }

        return left;
    }


    public boolean doesHaveKSmallerNums(int[][] matrix, int k, int target){

        int n = matrix.length;
        int i = n-1, j=0;
        int count = 0;

        while(i>=0 && j<n){

            if(matrix[i][j] > target){
                i--;
            }else{
                count += i + 1;
                j++;
            }

        }

        return (count >= k);

    }

}
