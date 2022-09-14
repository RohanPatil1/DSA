public class MaximumIndex {

    //First approach
    static int maxIndexDiffA1(int arr[], int n) {

        // Your code here

        int[] minLeft = new int[n];
        int[] maxRight = new int[n];


        minLeft[0] = arr[0];

        //Get Min from left
        for(int i=1;i<n;i++){
            minLeft[i] = Math.min(arr[i],minLeft[i-1]);

        }
        maxRight[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){

            maxRight[i] = Math.max(maxRight[i+1],arr[i]);

        }
        int i=0,j=0;
        int ans = -1;
        //Compute Ans
        while(i<n && j<n){
            if(minLeft[i] <= maxRight[j]){
                ans = Math.max(ans, j-i);
                j++;
            }else{
                i++;
            }

        }
        return ans;
    }


    //Best ans
    int maxIndexDiff(int arr[], int n) {
        int maxDiff = -1;

        int i = 0;
        int j = n - 1;

        while (i <= j) {

            if (arr[i] <= arr[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j = n - 1;
                i++;
            } else {
                j--;
            }

        }

        return maxDiff;
    }

}
