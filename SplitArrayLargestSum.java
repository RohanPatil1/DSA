public class SplitArrayLargestSum {

      /*
    Time: O(N * logSUM), where N <= 1000 is number of elements in array nums, SUM <= 10^9 is the total sum of all elements.
Space: O(1)
    */

    public boolean isValid(int[] nums, int limit, int splits){

        int currSplits = 1;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum > limit){
                currSplits++;
                sum = nums[i];
                if(currSplits > splits) return false;
            }
        }

        return true;
    }


    public int splitArray(int[] nums, int k) {

        int left = 0, right = 0, mid = 0;

        for(int num : nums){
            left = Math.max(left, num);
            right += num;
        }


        while(left < right){

            mid = left + (right - left)/2;

            if(isValid(nums, mid, k)){
                right = mid;
            }else{
                left = mid + 1;
            }


        }

        // Left is the minimal value satisfying isValid
        return left;
    }


}
