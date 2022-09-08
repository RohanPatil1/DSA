import java.util.Arrays;

public class WaveArray {
    public static void convertToWave(int n, int[] arr) {
        // code here
        Arrays.sort(arr);
        for(int i = 0; i< n-1; i+=2) {
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;

        }
    }
}
