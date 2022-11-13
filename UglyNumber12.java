public class UglyNumber12 {

    public static boolean isUglyNumber(int n) {

        //14 = 2*7
        //we consume all the 2s 3s 5s and lastly check if n is 1 which indicates that yes the number was
        //purely made from 2,3,5. If not, then false

        if (n <= 0) return false;

        //Consume all the 2s
        while (n % 2 == 0) n = n / 2;

        while (n % 3 == 0) n = n / 3;
        while (n % 5 == 0) n = n / 5;


        //After consuming all the 2s, 3s, 5s, we should be left with if not, then false
        if (n == 1) return true;

        return false;
    }

    //Time= O(N) Space=O(N)
    public static int nthUglyNumber(int n) {

        int[] arr = new int[n + 1];
        int p2 = 0, p3 = 0, p5 = 0;

        arr[0] = 1;
        int min = 0;
        for (int i = 1; i < n; i++) {

            min = Math.min(arr[p2] * 2, Math.min(arr[p3] * 3, arr[p5] * 5));
            arr[i] = min;

            if (min == arr[p2] * 2) p2++;
            if (min == arr[p3] * 3) p3++;
            if (min == arr[p5] * 5) p5++;

        }

        return arr[n - 1];
    }


}
