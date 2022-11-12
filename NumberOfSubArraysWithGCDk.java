public class NumberOfSubArraysWithGCDk {

    public int subarrayGCD(int[] arr, int k) {

        if(arr.length == 1 && arr[0] == k) return 1;

        //[9,3,1,2,6,3] k = 3
        int count = 0;


        //Generate all the sub arrays
        for (int i = 0; i < arr.length; i++) {
            int currGCD = arr[i];
            for (int j = i; j < arr.length; j++) {
                currGCD = gcd(arr[j],currGCD);

                if(currGCD == k) count++;
                else break;
            }
        }

        return count;
    }


    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
