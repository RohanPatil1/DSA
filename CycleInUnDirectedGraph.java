import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleInUnDirectedGraph {

    class CPair {
        int node;
        int parent;

        public CPair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    //NOTE: Consider Connected Component pattern
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        int[] visited = new int[V];


        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (detectCycleBFS(i, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }


    private boolean detectCycleBFS(int src, ArrayList<ArrayList<Integer>> adj, int[] visited) {

        Queue<CPair> q = new LinkedList<>();

        q.offer(new CPair(src, -1));
        visited[src] = 1;


        while (!q.isEmpty()) {
            CPair cPair = q.poll();
            int node = cPair.node;
            int parent = cPair.parent;

            for (int k : adj.get(node)) {
                if (visited[k] == 0) {
                    visited[k] = 1;
                    q.offer(new CPair(k, node));
                } else {
                    //Already visited - either parent or cycle
                    if (parent != k) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean detectCycleDFS(int src, int parent, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[src] = 1;


        for (int k : adj.get(src)) {
            if (visited[k] == 0) {
                if (detectCycleDFS(k, src, adj, visited)) {
                    return true;
                }
            } else {
                //either parent or cycle
                if (k != parent) {
                    return true;
                }
            }
        }
        return false;
    }

}
