import java.util.*;

public class MinimumPlatforms {

    public static int getPlatforms(int[] arr, int[] dept, int n) {
        int result = 0;
        Arrays.sort(arr);
        Arrays.sort(dept);

        int platNeeded = 1;
        int i = 1, j = 0;
        while (i < n && j < n) {
            if (arr[i] <= dept[j]) {
                platNeeded++;
                i++;
            } else if (arr[i] > dept[j]) {
                platNeeded--;
                j++;
            }

            result = Math.max(result, platNeeded);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = new int[] {50,120,200,550,700,850};
        int[] dept = new int[] {500,550,600,700,900,1000};
        int result =getPlatforms(arr, dept, 6);
        System.out.println(result);
    }
}
