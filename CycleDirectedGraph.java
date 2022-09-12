import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDirectedGraph {


    //Using TopoSort
    public static boolean detectBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        //If topo comes out <N then it has cycle
        Queue<Integer> q = new LinkedList<>();

        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int k : adj.get(i)) {
                indegree[k]++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        int[] topoArr = new int[V];
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            topoArr[i++] = node;
            for (int k : adj.get(node)) {
                indegree[k]--;
                if (indegree[k] == 0) q.add(k);
            }
        }

        //If matches then No Cycle
        //If not matches then Cycle
        return !(topoArr.length == V);
    }

    public boolean detectDFS(int src, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVisited) {

        visited[src] = 1;
        pathVisited[src] = 1;

        //Traverse All Nodes
        for (int k : adj.get(src)) {

            //If Not Visited
            if (visited[k] == 0) {

                if (detectDFS(k, adj, visited, pathVisited)) {
                    return true;
                }
            } else {

                //If the node is previously visited

                //visited + pathVisited
                if (pathVisited[k] == 1) {
                    return true;
                }

            }

        }

        pathVisited[src] = 0;
        return false;

    }


    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] visited = new int[V];
        int[] pathVisited = new int[V];


        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (detectDFS(i, adj, visited, pathVisited)) return true;
            }
        }

        return false;
    }

}
