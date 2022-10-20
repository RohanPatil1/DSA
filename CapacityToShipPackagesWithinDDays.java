public class CapacityToShipPackagesWithinDDays {

    public boolean isValid(int[] arr, int limit, int days){
        System.out.println(limit);
        int currDays = 1;

        int sum =0;
        for(int curr : arr){
            sum += curr;

            if(sum > limit){
                currDays++;
                sum = curr;
            }
        }

        if(currDays > days){
            return false;
        }

        return true;
    }


    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;
        for(int curr : weights){
            left = Math.max(left, curr);
            right += curr;
        }

        int mid = 0;
        int ans = 0;
        while(left < right){

            mid = left + (right - left)/2;

            if(isValid(weights , mid, days)){
                right = mid;
            }else{
                left = mid + 1;
            }


        }

        return left;
    }

}
