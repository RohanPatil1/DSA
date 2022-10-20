public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        return lmiBS(nums, target);
    }

    public int lmiBS(int[] arr, int X){

        int left = 0;
        int right = arr.length;

        while(left < right){
            int mid = left + (right - left)/2;
            if(arr[mid] < X) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}
