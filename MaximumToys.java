import java.util.Arrays;

public class MaximumToys {


    static int toyCount(int N, int K, int arr[]) {

        Arrays.sort(arr);
        int count = 0;
        int currAmount = K;
        for (int i = 0; i < N; i++) {

            if (currAmount >= arr[i]) {
                count++;
                currAmount -= arr[i];
            }

        }
        return count;
    }
}
