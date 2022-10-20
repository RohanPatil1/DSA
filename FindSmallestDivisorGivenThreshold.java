public class FindSmallestDivisorGivenThreshold {

    public int getSum(int[] nums , int divisor){

        int sum = 0;

        for(int curr : nums){

            if(curr % divisor == 0){
                sum += curr/divisor;
            }else{
                sum += curr/divisor + 1;
            }

        }

        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {

        int left = 1, right = 0;
        for(int curr : nums){

            right = Math.max(right, curr);
        }


        int ans = 0;
        int divisor = 1;
        while(left <= right){
            divisor = left + (right - left)/2;
            // if(divisor==0) continue;
            if(divisor <= 0 )return ans;
            if(getSum(nums, divisor) <= threshold){
                ans = divisor;
                right = divisor - 1;

                if((divisor-1) <= 0) return ans;

            }else{
                left = divisor +1;
            }

        }

        return ans;
    }

}
