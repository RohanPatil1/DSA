import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PathOfGreaterThanEqualToKlength {
    class Pair {
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    boolean pathMoreThanK(int V, int E, int K, int[] a) {
        // Code Here

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < 3 * E - 2; i += 3) {
            adj.get(a[i]).add(new Pair(a[i + 1], a[i + 2]));
            adj.get(a[i + 1]).add(new Pair(a[i], a[i + 2]));
        }

        Set<Integer> visitedSet = new HashSet<>();

        return dfs(0, adj, K, visitedSet);

    }

    public boolean dfs(int src, List<List<Pair>> adj, int k, Set<Integer> visitedSet) {
        visitedSet.add(src);

        if (k <= 0) {
            return true;
        }


        for (Pair adjN : adj.get(src)) {
            int adjNode = adjN.node;
            int adjWt = adjN.weight;


            if (visitedSet.contains(adjNode)) {
                continue; //Found cycle
            } else {


                if (adjWt >= k) {
                    return true;
                }

                if (dfs(adjNode, adj, k - adjWt, visitedSet)) {
                    return true;
                }

            }

        }


        visitedSet.remove(src);
        return false;
    }

}
