import java.util.*;

public class FourSum {

    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        // Sort the Array
        Arrays.sort(num);
        int n = num.length;
        for (int i = 0; i < n; i++) {

            int target2 = target - num[i];

            for (int j = i + 1; j < n; j++) {
                int target3 = target2 - num[j];

                int front = j + 1;
                int back = n - 1;
                while (front < back) {
                    int twoSum = num[front] + num[back];

                    if (twoSum < target3) {
                        front++;
                    } else if (twoSum > target3) {
                        back--;
                    } else {
                        // Got Ans
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[front]);
                        list.add(num[back]);
                        res.add(list);

                        // Remove duplicates of front
                        while (front < back && num[front] == list.get(2)) {
                            ++front;
                        }

                        // Remove duplicates of back
                        while (front < back && num[front] == list.get(3)) {
                            --back;
                        }

                    }

                }

                // Remove Duplicates of number j
                while (j + 1 < n && num[j + 1] == num[j]) {
                    ++j;
                }

            }

            // Remove Duplicates of number i
            while (i + 1 < n && num[i + 1] == num[i]) {
                ++i;
            }
        }

        return res;
    }

    public static void main(String[] arg) {
        int[] arr = { 10, 2, 3, 4, 5, 7, 8 };
        ArrayList<ArrayList<Integer>> ans = fourSum(arr, 23);
        for (ArrayList<Integer> v : ans) {
            for (int u : v) {
                System.out.print(u + " ");
            }
            System.out.println();
        }
    }
}
