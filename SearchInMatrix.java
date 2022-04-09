
import java.util.*;

public class SearchInMatrix {

    public static int getElementINFarr(int[][] arr, int n, int m, int key) {
        int result = 0;

        int i = 0;
        int j = m - 1;
        List<Integer> res = new ArrayList<>();

        // In Bound
        while (i >= 0 && i < n && j >= 0 && j < m) {
            if (arr[i][j] == key) {
                return i; // i,j
            } else if (arr[i][j] > key) {
                // Go left of the curr row
                j--;
            } else if (arr[i][j] < key) {
                // Go down of the curr column
                i++;
            }
        }

        return result;
    }

  
    public static long factorial(int n, int m) {
        int res = 0;
        int i, fact = 1;

        for (i = 1; i <= n; i++) {
            fact = fact * i;
        }

        res = fact / m;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5, 2));


    }

}
