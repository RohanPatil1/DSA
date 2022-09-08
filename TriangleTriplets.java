public class TriangleTriplets {


    //BruteForce
    public static int countTriplets1(int[] arr) {
        int count = 0;

        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int k = n - 1;
                int sumIJ = arr[i] + arr[j];
                while (k < j) {
                    if (sumIJ > arr[k]) {
                        count++;
                    }
                    k--;
                }
            }
        }
        return count;
    }


    //ThreePointers
    public static int countTriplets2(int[] arr) {

        int count = 0;
        int j = 0;
        int k = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            k = i - 1;

            while (j < k) {
                int sum = arr[j] + arr[k];
                if (sum > arr[i]) {
                    count += k - j;
                    k--;
                } else {
                    j++;
                }
            }
        }
        return count;
    }


}
