import java.util.*;

// // class Pair implements Comparable<Pair> {
// //     Integer value;
// //     Integer index;

// //     public Pair(Integer value, Integer index) {
// //         this.value = value;
// //         this.index = index;
// //     }

// //     @Override
// //     public int compareTo(Pair o) {
// //         return value - o.value;
// //     }
// // }

// class pair implements Comparable<pair> {
//     int hn;
//     int d;

//     pair(int hn, int d) {
//         this.hn = hn;
//         this.d = d;
//     }

//     public int compareTo(pair o) {
//         if (this.d == o.d)
//             return this.hn - o.hn;
//         else
//             return this.d - o.d;
//     }

// }

public class TopKFrequent {

    // 1 1 1 3 2 2 4 k=2 Output=> 1,2
    public static void topKFreq(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        //Frequency Map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //MinHeap 
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (int key : map.keySet()) {
            queue.add(key);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            System.out.print(queue.peek()+" ");
            ans.add(queue.poll());
        }

        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++){
            result[i] = ans.get(i);
        }

      //  return result;
    }

    public static void main(String[] args) {

        topKFreq(new int[] { 1, 1, 1, 3, 2, 2, 4 }, 2);
    }
}
