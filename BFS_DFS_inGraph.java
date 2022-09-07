import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BFS_DFS_inGraph {


    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        ArrayList<Integer> ans = new ArrayList<>();

        int size = adj.size();
        int[] visited = new int[V + 1];


        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = 1;

        while (!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            ans.add(node);

            //Check for its adjacent nodes
            for (int k : adj.get(node)) {
                if (visited[k] != 1) {
                    visited[k] = 1;
                    q.add(k);
                }
            }
        }
        return ans;
    }


    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here


        ArrayList<Integer> ans = new ArrayList<Integer>();

        dfsHelper(adj, ans, 0);


        return ans;
    }


    public static void dfsHelper(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, int src) {
        ans.add(src);
        for (int k : adj.get(src)) {
            if(!ans.contains(k)){
                dfsHelper(adj,ans,k);
            }
        }
    }

}
