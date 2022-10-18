public class SquaresOfSortedArray {

    //Time = O(N) Space O(1) output[] is the req space for output
    public int square(int num){
        return num*num;
    }

    public void reverseArr(int[] arr, int start, int end){

        while(start <= end){

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }


    }

    public int[] sortedSquares(int[] nums) {


        int n = nums.length;
        int[] output = new int[n];

        int i =0;
        int j = n-1;

        int k = 0;
        while(i <= j){

            if(square(nums[i]) < square(nums[j]) ){
                output[k++] = square(nums[j]);
                j--;
            }else{
                output[k++] = square(nums[i]);
                i++;
            }

        }

        reverseArr(output, 0, n-1);
        return output;

    }
}
