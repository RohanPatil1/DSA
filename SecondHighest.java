import java.util.*;
// import java.collections;

public class SecondHighest {

    public static int getThirdHighest(int[] arr, int k) {
        int result = 0;
        // Using MinHeap

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (pq.peek() < arr[i]) {

                pq.poll();
                pq.add(arr[i]);
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {

        int[] arr = { 9, -1, 3, 5, 6, 55, 10, 44 };

        int n = arr.length;

        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            // If currElement is potential highest
            if (arr[i] > highest) {
                secondHighest = highest;
                highest = arr[i];
            }

            // If currElement is potential secondHighest
            if (highest > arr[i] && arr[i] > secondHighest) {
                secondHighest = arr[i];
            }

        }

    }
}