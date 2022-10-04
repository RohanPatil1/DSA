import java.util.Arrays;

public class MinimumMultiplicationstoReachEnd {

    int minimumMultiplications(int[] arr, int start, int end) {

        Arrays.sort(arr);
        int n = arr.length;
        int target = end;
        int stepCount = 0;
        while (target != start) {
            for (int i = n - 1; i >= 0; i--) {
                if (target % arr[i] == 0 && (target / arr[i]) >= start) {
                    target /= arr[i];
                    stepCount++;
                }
                if (target == start) {
                    return stepCount;
                }
            }
        }

        return stepCount;
    }

}
