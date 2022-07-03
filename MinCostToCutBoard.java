import java.util.*;


public class MinCostToCutBoard {


    public static int[] reverseSort (int[] arr) {



        for (int i = 0; i < arr.length; i++) {
            arr[i] *=-1;
        }
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            arr[i] *=-1;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        return arr;
    }

    public static int minimumCostOfBreaking(int[] x, int[] y, int m, int n) {
        // code here
        int cost = 0;

        reverseSort(x);
        reverseSort(y);


        int i = 0, j = 0;

        int horizontal = 1;
        int vertical = 1;
        while (i < m && j < n) {

            if (x[i] > y[j]) {
                cost += x[i] * vertical;
                horizontal++;
                i++;
            } else {
                cost += y[j] * horizontal;
                vertical++;
                j++;
            }
        }

        //one left out loop
        while (i < m) {
            cost += x[i] * vertical;
            i++;
        }

        while (j < n) {
            cost += y[j] * horizontal;
            j++;
        }

        return cost;
    }


    public static void main(String[] args) {
    }
}
