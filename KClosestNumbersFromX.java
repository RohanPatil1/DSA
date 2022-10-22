import java.util.*;

// class Pair {
//     Integer key;
//     Integer value;

//     public Pair(Integer key, Integer value) {
//         this.key = key;
//         this.value = value;
//     }

//     public Integer getKey() {
//         return key;
//     }

//     public void setKey(Integer key) {
//         this.key = key;
//     }

//     public Integer getValue() {
//         return value;
//     }

//     public void setValue(Integer value) {
//         this.value = value;
//     }
// }



class pair implements Comparable<pair> {
    int hn;
    int d;

    pair(int hn, int d) {
        this.hn = hn;
        this.d = d;
    }

    public int compareTo(pair o) {
        if (this.d == o.d)
            return this.hn - o.hn;
        else
            return this.d - o.d;
    }

}

public class KClosestNumbersFromX {

    // public static void printKclosest(int[] arr, int n,
    // int x, int k) {

    // // MaxHeap
    // PriorityQueue<Pair> pq = new PriorityQueue<>(
    // new Comparator<Pair>() {
    // public int compare(Pair p1, Pair p2) {
    // return p2.getValue().compareTo(
    // p1.getValue());
    // }
    // });

    // // Heap(arr[i],diff) for first k elements
    // for (int i = 0; i < k; i++) {
    // pq.offer(new Pair(arr[i],
    // Math.abs(arr[i] - x)));
    // }

    // // Now process remaining elements.
    // for (int i = k; i < n; i++) {
    // int diff = Math.abs(arr[i] - x);

    // // If difference with current
    // // element is more than root,
    // // then ignore it.
    // if (diff > pq.peek().getValue())
    // continue;

    // // Else remove root and insert
    // pq.poll();
    // pq.offer(new Pair(arr[i], diff));
    // }

    // // Print contents of heap.
    // while (!pq.isEmpty()) {
    // System.out.print(pq.poll().getKey() + " ");
    // }
    // }

    public static void printKclosest2(int[] arr, int n,
            int x, int k) {
        // MaxHeap
        ArrayList<Integer> result = new ArrayList<Integer>();
        PriorityQueue<pair> pq = new PriorityQueue<>();

        //Add arr[i] and diff to heap
        for (int i = 0; i < n; i++) {
            pair p = new pair(arr[i], Math.abs(x - arr[i]));
            pq.add(p);
        }

        //Get First k results
        for (int i = 0; i < k; i++) {
            result.add(pq.poll().hn);
        }

        //Required for
        Collections.sort(result);

        // Print Result
        for (int i = 0; i < k; i++) {
            System.out.print(result.get(i) + " ");
        }

    }

    public static void main(String[] args) {
        int arr[] = { 10, 50, 20, 17, 80 };
        int x = 20, k = 3;
        int n = arr.length;
        // printKclosest(arr, n, x, k);
        System.out.println();
        printKclosest2(new int[] { 10, 2, 14, 4, 7, 6 }, 6, 5, 3);
    }
}
