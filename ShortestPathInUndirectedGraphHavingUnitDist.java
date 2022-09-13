import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUndirectedGraphHavingUnitDist {


    public int[] shortestPath(int[][] edges, int n, int m, int src) {

        //Constructing adj list the Undirected graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        //Get Distance
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int k : adj.get(node)) {
                if (dist[node] + 1 < dist[k]) {
                    dist[k] = dist[node] + 1;
                    q.add(k);
                }
            }
        }

        //Replace unreachable with -1
        for (int i = 0; i < n; i++) {
            if (dist[i] == 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }


}
