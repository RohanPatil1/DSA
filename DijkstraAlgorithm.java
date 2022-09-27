import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src)
    {

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
}
