import java.util.Arrays;

public class CoinPiles {




    static int upperBound(int[] arr, int permissible) {
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= permissible) {
                index++;
            }
        }
        return index;
    }


    //TODO needs changes
    static int minSteps(int[] arr, int n, int k) {
        // code here



        int ans = Integer.MAX_VALUE;

        Arrays.sort(arr);

        //Prefix Sum
        int[] prefixArr = new int[n];
        prefixArr[0] = arr[0];
        for (int i =1; i < n; i++) {
            prefixArr[i] = prefixArr[i - 1] + arr[i];
        }
        int prev = 0;

        for (int i = 0; i < n; i++) {

            //Has count of left element
            int c = 1;
            while ((i + 1) < n && arr[i] == arr[i + 1]) {
                i++;
                c++;
                continue;
            }


            int permissible = arr[i] + k;                   //12
            int index = upperBound(arr, permissible);       // index of 15


            //RIGHT
            int actualSum = (prefixArr[n - 1] - prefixArr[index - 1]);  //53
            int reduce = (n - index) * permissible; //3*12  count of numbers greater than permissible X permissib;e
            actualSum = actualSum - reduce;
            ans = Math.min(ans, actualSum + prev);
            prev += (arr[i] * c);

        }
        return ans;

    }

}
