import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlgorithm {

    static class Edge {
        private int u;
        private int v;
        private int weight;

        Edge(int _u, int _v, int _w) {
            u = _u;
            v = _v;
            weight = _w;
        }

    }


    public static int[] shortestPath(ArrayList<Edge> adj, int n) {
        int[] dist = new int[n];

        //Init distances with max
        Arrays.fill(dist, Integer.MAX_VALUE);

        //Src to 0
        dist[0] = 0;

        //Relaxation for n-1 times
        for (int i = 1; i <= (n - 1); i++) {
            for (Edge edge : adj) {
                if (dist[edge.u] + edge.weight < dist[edge.v]) {
                    dist[edge.v] = dist[edge.u] + edge.weight;
                }
            }
        }

        //Check for negative cycle
        int flag = 0;
        for (Edge edge : adj) {
            if (dist[edge.u] + edge.weight < dist[edge.v]) {
                flag = 1;
                System.out.println("Negative Cycle");
                break;
            }
        }

        if (flag == 0) {
            return dist;
        }


        return new int[]{};
    }
}
