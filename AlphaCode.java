import java.util.Arrays;

public class AlphaCode {

    static int[] t = new int[1001];
    public static int countCode(int[] arr, int n) {
        if (n == 1 || n == 0) return 1;

        if(t[n]!=-1){
            return t[n];
        }

        int count = countCode(arr, n - 1);

        if (arr[n - 2] * 10 + arr[n - 1] <= 26) {
            System.out.println("2digit: "+(arr[n - 2] * 10 + arr[n - 1]));
            count += countCode(arr, n - 2);
        }
        t[n] = count;
        return count;
    }

    public static void main(String[] args) {
        Arrays.fill(t,-1);
        System.out.println(countCode(new int[]{1,1,2,3},4));
    }
}
