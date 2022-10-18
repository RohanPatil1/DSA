import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumTimeTakenByEachJobToBeCompletedDAG {

/*
Time Complexity: O(V+E), where V is the number of nodes and E is the number of edges.
Auxiliary Space: O(V)
 */
    public static void printTimeOrder(int V, ArrayList<ArrayList<Integer>> adj) {

        //Make Indegree
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int k : adj.get(i)) {
                indegree[k]++;
            }
        }

        //Add 0s to q
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        int time = 1;
        while (!q.isEmpty()) {
            int currNode = q.poll();
            System.out.print(time + " ");
            for (int k : adj.get(currNode)) {
                indegree[k]--;
                if (indegree[k] == 0) q.add(k);
            }
            time++;
        }
    }

}
