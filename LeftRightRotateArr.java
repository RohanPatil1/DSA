public class LeftRightRotateArr {
    

    public  void rotateLeft(int[] nums,int k) {

        int n = nums.length;

        k = k%n;
        if(k==0) return;
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
        reverse(nums, 0, n-1);
    }


    public void rotateRight(int[] nums, int k) {

        int n = nums.length;

        k = k%n;
        if(k==0) return;

        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);

    }


    public void reverse(int[] arr, int i, int j){

        while(i<j){

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

    }

}
