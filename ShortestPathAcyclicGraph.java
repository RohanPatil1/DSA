import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPathAcyclicGraph {


    class GPair {
        int u;
        int v;
        int cost;

        public GPair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    public int[] shortestPath(int N, int M, int[][] edges) {

        //Construct Adjacency List
        ArrayList<ArrayList<GPair>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<GPair>());
        }

        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int cost = edges[i][2];
            GPair currP = new GPair(v, cost);
            adj.get(u).add(currP);
        }


        //Topological Sort
        int[] visited = new int[N];
        Stack<Integer> topoStack = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                topoDFS(i, adj, visited, topoStack);
            }
        }

        //Get The Shortest Distance
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // Src distance is to itself is 0

        while (!topoStack.isEmpty()) {
            int node = topoStack.pop();
            for (GPair k : adj.get(node)) {
                int v = k.v;
                int cost = k.cost;
                if (dist[node] + cost < dist[v]) {
                    dist[v] = dist[node] + cost;
                }
            }

        }

        return dist;
    }

    private void topoDFS(int src, ArrayList<ArrayList<GPair>> adj, int[] visited, Stack<Integer> topoStack) {
        visited[src] = 1;

        for (GPair k : adj.get(src)) {
            if (visited[k.v] == 0) {
                topoDFS(k.v, adj, visited, topoStack);
            }
        }
        topoStack.add(src);
    }
}
