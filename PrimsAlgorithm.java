import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class WNode {

    int v;
    int weight;
    public WNode( int v,int weight) {
        this.weight = weight;
        this.v = v;
    }
}

class WNodeComparator implements Comparator<WNode> {

    @Override
    public int compare(WNode o1, WNode o2) {
        return o1.weight - o2.weight;
    }
}

//https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1
public class PrimsAlgorithm {
    static void spanningTree(int V, ArrayList<ArrayList<WNode>> adj) {
        // System.out.println(adj);

        PriorityQueue<WNode> pq = new PriorityQueue<>(new WNodeComparator());
        int[] visited = new int[V];

        pq.add(new WNode(0, -1));


        while (!pq.isEmpty()) {
            WNode currNode = pq.poll();

            if (visited[currNode.v] == 1) {
                continue;
            }


            visited[currNode.v] = 1;

            for (WNode edge : adj.get(currNode.v)) {
                if (visited[edge.v] == 0) {
                    pq.add(new WNode(edge.v, edge.weight));
                }
            }
            if (currNode.weight != -1) System.out.print(currNode.v + " ");

        }
    }

    public static void main(String args[]) {
        int n = 5;
        ArrayList<ArrayList<WNode>> adj = new ArrayList<ArrayList<WNode>>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<WNode>());

        adj.get(0).add(new WNode(1, 2));
        adj.get(1).add(new WNode(0, 2));

        adj.get(1).add(new WNode(2, 3));
        adj.get(2).add(new WNode(1, 3));

        adj.get(0).add(new WNode(3, 6));
        adj.get(3).add(new WNode(0, 6));

        adj.get(1).add(new WNode(3, 8));
        adj.get(3).add(new WNode(1, 8));

        adj.get(1).add(new WNode(4, 5));
        adj.get(4).add(new WNode(1, 5));

        adj.get(2).add(new WNode(4, 7));
        adj.get(4).add(new WNode(2, 7));

        spanningTree(n,adj);
    }


}
