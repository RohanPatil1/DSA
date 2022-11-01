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

    //A1 - Use MaxHeap then get top k elements Time => O(NLogN)
    //A2 - Use MinHeap of k size, pop if size>k Time => O(NLogK)

    //A3 - Bucket Sort Time => O(N)
    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;
        List<Integer>[] bucketArr = new List[ n + 1];

        //Frequency Map
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //Fill Bucket Arr
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucketArr[freq] == null){
                bucketArr[freq] = new ArrayList<>();
            }

            bucketArr[freq].add(key);
        }

        //For top k frequent, go right->left get k elemets
        int count =  0;
        int[] topKArr = new int[k];

        for(int i=n; i>=0; i--){

            if(bucketArr[i] == null) continue;

            List<Integer> currBucket = bucketArr[i];

            for(int j=0; j<currBucket.size(); j++){
                topKArr[count++] = currBucket.get(j);
                if(count == k) break;
            }

            if(count == k) break;

        }


        return topKArr;

    }


    public static void main(String[] args) {

        topKFreq(new int[] { 1, 1, 1, 3, 2, 2, 4 }, 2);
    }
}
