import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class MinimumMultiplicationstoReachEnd {

//    int minimumMultiplications(int[] arr, int start, int end) {
//
//        Arrays.sort(arr);
//        int n = arr.length;
//        int target = end;
//        int stepCount = 0;
//        while (target != start) {
//            for (int i = n - 1; i >= 0; i--) {
//                if (target % arr[i] == 0 && (target / arr[i]) >= start) {
//                    target /= arr[i];
//                    stepCount++;
//                }
//                if (target == start) {
//                    return stepCount;
//                }
//            }
//        }
//
//        return stepCount;
//    }

    class Pair{
        int steps;
        int num;

        public Pair(int steps, int num){
            this.steps = steps;
            this.num = num;
        }
    }

    int minimumMultiplications(int[] arr, int start, int end) {

        int[] distance = new int[100000];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, start));


        while(!q.isEmpty()){
            Pair parentP = q.poll();
            int parentStep = parentP.steps;
            int parentNum = parentP.num;


            for(int k : arr){
                int numK = (k * parentNum)%100000;
                if(parentStep + 1 < distance[numK]){
                    distance[numK] = parentStep + 1;
                    q.add(new Pair(parentStep + 1, numK));
                }
            }

        }


        if(distance[end] == Integer.MAX_VALUE) return -1;

        return distance[end];
    }

}
