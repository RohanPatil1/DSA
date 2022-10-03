import java.util.*;

public class DijkstraAlgorithm {
    static class GNode {
        int node;
        int weight;

        public GNode(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static class GNodeComparator implements Comparator<GNode> {
        @Override
        public int compare(GNode o1, GNode o2) {
            return o1.weight - o2.weight;
        }
    }

    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {

        /*
        adj = {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}}
        V = 3, E = 3
        S = 2

        0=[ [1,1], [2,6] ]
        1=[ [2,3], [0,1] ]
        2=[ [1,3], [0,6] ]
         */

        // Write your code here
        PriorityQueue<GNode> pq = new PriorityQueue<>(new GNodeComparator());
        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        //Add Source
        pq.offer(new GNode(src, 0));
        dist[src] = 0;
        while (!pq.isEmpty()) {
            GNode currGNode = pq.poll();
            int node = currGNode.node;
            int nodeWeight = currGNode.weight;
            ArrayList<ArrayList<Integer>> list = adj.get(node);
            //Traverse all adj nodes
            for (int i = 0; i < list.size(); i++) {
                ArrayList<Integer> weightList = list.get(i);
                int v = weightList.get(0);
                int weight = weightList.get(1);

                if (nodeWeight + weight < dist[v]) {
                    dist[v] = nodeWeight + weight;

                    GNode vnode = new GNode(v, dist[v]);
                    pq.add(vnode);
                }
            }

        }

        return dist;
    }

    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<Integer> pathList = new ArrayList<>();

        //Adjacency List
        ArrayList<ArrayList<GNode>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }


        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new GNode(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new GNode(edges[i][0], edges[i][2])); //Undirected graph
        }

        PriorityQueue<GNode> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        int[] distance = new int[n + 1];
        int[] parent = new int[n + 1];
        //init distance & parent
        for (int i = 1; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }

        distance[1] = 0;
        pq.add(new GNode(1, 0));


        while (!pq.isEmpty()) {
            GNode currGNode = pq.poll();
            int currWeight = currGNode.weight;
            int currNode = currGNode.node;

            for (GNode k : adj.get(currNode)) {
                int kNode = k.node;
                int kWeight = k.weight;

                if (currWeight + kWeight < distance[kNode]) {
                    distance[kNode] = currWeight + kWeight;
                    pq.add(new GNode(kNode, distance[kNode]));
                    parent[kNode] = currNode;
                }

            }
        }

        if (distance[n] == Integer.MAX_VALUE) {
            pathList.add(-1);
            return pathList;
        }

        int node = n;
        while (parent[node] != node) {
            pathList.add(node);
            node = parent[node];
        }
        pathList.add(1);
        Collections.reverse(pathList);
        return pathList;
    }

    public static void main(String[] args) {
        int[][] nasd = new int[][]{
                {1, 2, 2},
                {2, 5, 5},
                {2, 3, 4},
                {1, 4, 1},
                {4, 3, 3},
                {3, 5, 1}
        };
        System.out.println(shortestPath(5,6,nasd));

    }
}
