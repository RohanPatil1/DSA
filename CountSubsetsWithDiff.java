import java.util.*;

public class CountSubsetsWithDiff {



    public static int getCount(int[] arr, int diff) {

        int count = 0;

        int sum = 0;
        // Get arr sum
        for (int x : arr) {
            sum += x;
        }

        int s1 = (diff + sum) / 2;

        // Get count of subset having sum s1
        int n = arr.length;
        int s = s1;
        System.out.println("S1: " + s);
        int[][] t = new int[n + 1][s + 1];

        // Init matrix
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < s + 1; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                } 
                 if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        // Fill the rest
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < s + 1; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        // for (int i = 1; i < n + 1; i++) {
        //     for (int j = 1; j < s + 1; j++) {
        //         System.out.println(t[i][j]);
        //     }
        //     System.out.println();

        // }

        count = t[n][s];

        return count;
    }

    public static void main(String[] args) {
        System.out.println(getCount(new int[] { 1, 1, 2, 3 }, 1));
    }
}
