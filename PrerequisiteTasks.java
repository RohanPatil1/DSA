import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrerequisiteTasks {


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

    public static boolean topoBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[V];

        //Fill indegree
        for (int i = 0; i < V; i++) {
            for (int k : adj.get(i)) {
                indegree[k]++;
            }
        }

        //Add nodes with indegree=0 to queue
        for (int i = 0; i < V; i++) {
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int topoCount = 0;
        //BFS
        while(!q.isEmpty()){

            int node = q.poll();
            topoCount++;

            for(int k:adj.get(node)){
                indegree[k]--;
                if(indegree[k]==0){
                    q.add(k);
                }
            }

        }
        return topoCount==V;

    }


    public boolean isPossible(int N, int[][] prerequisites) {
        // Your Code goes here
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[N];
        int[] pathVisited = new int[N];
        //Construct adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++)
            adj.add(new ArrayList<>());


        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                if (detectDFS(i, adj, visited, pathVisited)) return false;
            }
        }

        return true;
    }
}
