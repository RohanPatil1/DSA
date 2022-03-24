import java.util.*;

class CustomComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer number1, Integer number2) {
        int value = number1.compareTo(number2);

        // elements are sorted in reverse order
        if (value > 0) {
            return -1;
        } else if (value < 0) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class KthSmallestLargest {

    public static int kthSmallest(int[] arr, int k) {
        // MaxHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>(new CustomComparator());

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        System.out.println(pq.peek());
        return pq.peek();
    }

    public static int kLargestElements(int[] arr, int k) {
        // MINHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (pq.size() > 0) {
            System.out.println(pq.peek());
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {

        int[] arr = { 9, -1, 3, 5, 6, 55, 10, 44 };

        kthSmallest(arr, 3);
        kLargestElements(arr, 3);

    }
}
