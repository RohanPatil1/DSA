public class RainwaterProblem {

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int getRainWater(int[] arr) {
        int rain = 0;
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        //Fill the aux
        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }
        printArr(left);

        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        printArr(right);


        //Get Rain by min(left[i],right[i]) - a[i]
        for (int k = 0; k < n; k++) {
            rain += Math.min(left[k], right[k]) - arr[k];
        }

        return rain;

    }


    public static int trappingRainWater(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int maxLeft = 0, maxRight = 0;
        int water = 0;

        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= maxLeft) maxLeft = arr[left];
                else water += maxLeft - arr[left];

                left++;
            } else {
                if (arr[right] >= maxRight) maxRight = arr[right];
                else water += maxRight - arr[right];

                right--;
            }
        }

        return water;
    }

    public int trap(int[] height) {


        int left =0 ,right =height.length-1;
        int leftMax =height[left], rightMax = height[right];

        int water = 0;


        while(left<right){

            if(leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax , height[left]);

                water += leftMax - height[left];

            }else{
                right--;
                rightMax = Math.max(rightMax, height[right]);

                water += rightMax - height[right];
            }


        }


        return water;
    }


    public static void main(String[] args) {


        int[] arr = {3, 1, 2, 4, 0, 1, 3, 2};
        int ans = getRainWater(arr);
        System.out.println(ans);

    }
}
