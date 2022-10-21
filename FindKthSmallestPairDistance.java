import java.util.Arrays;

public class FindKthSmallestPairDistance {
    //https://leetcode.com/problems/find-k-th-smallest-pair-distance/discuss/109082/Approach-the-problem-using-the-%22trial-and-error%22-algorithm

    public boolean doesHaveKSmallerPairs(int[] nums, int distance, int k){

        System.out.println("========="+distance+"============");

        int j=0,i=0,count=0;
        for(j=0; j<nums.length; j++){
            //Reduce the window when out of range of currDistance
            while(nums[j] - nums[i] > distance){
                i++;
            }

            count += j - i;
            System.out.println("i:"+i+"  j:"+j+"  count="+count);
        }


        return count >= k;
    }

    public int smallestDistancePair(int[] nums, int k) {
        int left = 0;
        int  right, mid;
        int n = nums.length;
        Arrays.sort(nums);
        right = nums[n-1] - nums[0];



        while(left < right){
            mid = left + (right - left)/2;

            if(doesHaveKSmallerPairs(nums, mid, k)){
                right = mid;
            }else{
                left = mid + 1;
            }


        }

        return left;
    }
}


