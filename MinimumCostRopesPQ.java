import java.util.PriorityQueue;

public class MinimumCostRopesPQ {

    public static long minCost(long[] arr) {
        int n = arr.length;
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        long cost = 0;

        for (int i = 0; i < n; i++) {
            minHeap.add(arr[i]);
        }

        while (minHeap.size() >= 2) {
            long first = minHeap.poll();
            long second = minHeap.poll();

            cost = cost + first + second;
            minHeap.add(cost);
        }

        return cost;

    }


}
