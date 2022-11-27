import java.util.*;

public class CountSubarraysWithMedianK {

    ///TLE
    public int countSubarrays(int[] nums, int k) {


        // Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();

        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            list.add(nums[i]);

            for (int j = i; j < nums.length; j++) {

                if (i == j) {
                    if (list.get(0) == k) count++;
                    continue;
                }

                list.add(nums[j]);
                Collections.sort(list);
                int size = list.size();
                int midElement = 0;

                if (size % 2 == 0) {
                    int mid = (size / 2) - 1;
                    if (mid >= 0) {
                        midElement = list.get(mid);
                    } else {
                        midElement = list.get(0);
                    }
                } else {

                    int mid = size / 2;
                    midElement = list.get(mid);
                }

                if (midElement == k) {
                    count++;
                }

            }

            list.clear();

        }

        return count;
    }


    ///TLE
    public int countSubarrays2(int[] nums, int k) {


        PriorityQueue<Integer> leftPq = new PriorityQueue(Collections.reverseOrder());
        PriorityQueue<Integer> rightPq = new PriorityQueue();


        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            leftPq.add(nums[i]);

            for (int j = i; j < nums.length; j++) {

                if (i == j) {
                    if (nums[i] == k) count++;
                    continue;
                }


                if (nums[j] > rightPq.peek()) {
                    rightPq.add(nums[j]);
                } else {
                    leftPq.add(nums[j]);
                }

                if ((leftPq.size() - rightPq.size()) > 1) {
                    int rem = leftPq.poll();
                    rightPq.add(rem);
                }

                int size = leftPq.size() + rightPq.size();
                int midElement = 0;

                if (size % 2 == 0) {
                    midElement = leftPq.peek();
                } else {

                    if (leftPq.size() > rightPq.size()) {
                        midElement = leftPq.peek();
                    } else {
                        midElement = rightPq.peek();
                    }
                }

                if (midElement == k) {
                    count++;
                }

            }

            rightPq.clear();
            leftPq.clear();

        }

        return count;
    }
}
