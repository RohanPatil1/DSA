import java.util.*;

public class ArrayIntersection {

    public static List<Integer> intersectArr(int[][] arr) {
        List<Integer> ans = new ArrayList<>();

        int n = arr.length;
        for (int[] rows : arr) {
            Arrays.sort(rows);
        }

        for (int i = 0; i < arr[0].length; i++) {

            int search = arr[0][i];
            int count = 0;

            for (int j = 0; j < n; j++) {
                List<Integer> intList = new ArrayList<Integer>(arr[j].length);
                for (int k : arr[j]) {
                    intList.add(k);
                }

                int a = Collections.binarySearch(intList, search);

                if (a >= 0) {
                    count++;
                }
                if (count == n) {
                    ans.add(search);
                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][] {
                { 1, 2, 3 },
                { 4, 2, 3 }
        };

        System.out.println(intersectArr(nums).toString());

    }
}
