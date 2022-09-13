import java.util.Arrays;

public class FrequencyOftheMostFrequentElement {

    //https://www.youtube.com/watch?v=vgBrQ0NM5vE&ab_channel=NeetCode

    /*
    If someone wants help with the intuition behind the condition, its basically asking from the
     current sliding window e.g. [1, 2,  4], how much do you need to convert it in [4, ,4 ,4],
     you would need 4 (nums[r]) times the window length (r - l + 1) - the sum of the current window.
     So nums[r]*(r-l+1) - sum, if this is affordable with budget k (nums[r]*(r-l+1) - sum <= k) then
     a frequency can be achieved with an amount equal to the window length.
    (e.g. 1 + 2 + 4 = 7, 4 + 4 + 4 = 12, you need 5 to convert it, which is within budget).
     */


    public int maxFrequency(int[] nums, int k) {

        int i = 0, j = 0;
        int n = nums.length;
        int maxFreq = 0;

        long currSum = 0;

        Arrays.sort(nums); // So that we can use least k like [1,1,2,2,4] k=2 Now if want to make 4 the best option is 2 not 1


        while (j < n) {
            currSum += nums[j];
            //WE are trying to make nums[j]
            //We will keep growing out window from left(i) until budget

            /*
            i      j
            [1,1,1,2, 2,4] k=2
            So we are trying to make [1,1,1,2] to [2,2,2,2]
            so windowSize*num[j] i.e expected sum if all became 2

            Ans currSum+k is the reality sum which is possible
             */

            //Not expected? increase i & reduce currSum i.e reduce expectations
            while ((long) nums[j] * (j - i + 1) > (currSum + k)) {

                currSum -= nums[i];
                i++;
            }

            maxFreq = Math.max(maxFreq, j - i + 1);
            j++;

        }

        return maxFreq;
    }

}
