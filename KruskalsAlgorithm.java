import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class KruskalsAlgorithm {

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

    static  class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }


    //----DISJOINT SET UTILS--------
    static  private int findParent(int u, int[] parent) {
        if (u == parent[u]) return u;
        return parent[u] = findParent(parent[u], parent);
    }

    static private void union(int u, int v, int[] parent, int[] height) {
        u = findParent(u, parent);
        v = findParent(v, parent);
        if (height[u] < height[v]) {
            parent[u] = v;
        } else if (height[v] < height[u]) {
            parent[v] = u;
        } else {
            parent[v] = u;
            height[u]++;
        }
    }


   static void kruskalAlgo(ArrayList<Edge> adj, int N) {
        Collections.sort(adj, new EdgeComparator());
        int[] parent = new int[N];
        int[] height = new int[N];


        //Init
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            height[i] = 0;
        }

        int costMst = 0;
        ArrayList<Edge> mst = new ArrayList<>();
        for (Edge edge : adj) {

            //Check if in same component or not
            if (findParent(edge.u, parent) != findParent(edge.v, parent)) {
                costMst += edge.weight;
                mst.add(edge);
                union(edge.u, edge.v, parent, height); //Join component
            }

        }

        //Print MST
        for (Edge edge : mst) {
            System.out.println(edge.u + " - " + edge.v);
        }

    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<Edge> adj = new ArrayList<Edge>();


        adj.add(new Edge(0, 1, 2));
        adj.add(new Edge(0, 3, 6));
        adj.add(new Edge(1, 3, 8));
        adj.add(new Edge(1, 2, 3));
        adj.add(new Edge(1, 4, 5));
        adj.add(new Edge(2, 4, 7));


        kruskalAlgo(adj,n);
    }

}
