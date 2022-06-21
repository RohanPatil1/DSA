import java.util.*;

public class FindPairOfSumFromTwoArr {
    class pair {
        long first, second;

        public pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }

    public ArrayList<pair> allPairs(long arr1[], long arr2[], long n, long m, long X) {

        ArrayList<pair> ansL = new ArrayList<pair>();
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(arr2[i], i);
        }

        for (int i = 0; i < n; i++) {
            long curr = arr1[i];
            if (map.containsKey(X - curr)) {
                int jIndex = map.get(X - curr);
                // pair subA = new pair(curr,arr[jIndex]);
                ansL.add(new pair(curr, arr2[jIndex]));
            }
        }

        return ansL;

    }
}
