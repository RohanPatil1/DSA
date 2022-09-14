import java.util.Arrays;

public class SearchInfinteArray {


    public static int findInInfiniteArr(int[] arr, int x) {

        int start = 0;
        int end = 1;

        while (arr[end] < x) {
            start = end;
            end = end * 2;
        }
        //Binary searh
        int a = Arrays.binarySearch(arr, x);
        return a;
    }
}
