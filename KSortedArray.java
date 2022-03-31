import java.util.*;

public class KSortedArray {

    public static void kSortedArr(int[] arr, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);

            if (minHeap.size() > k) {
                result.add(minHeap.peek());
                minHeap.poll();
            }
        }

        // Print Result
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    public static void main(String[] args) {

        int[] arr = { 6, 5, 3, 2, 8, 10, 9 };
        kSortedArr(arr, 3);
    }
}
