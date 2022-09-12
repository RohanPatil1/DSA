import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
    static int[] topoBFS(int V, ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();

        int[] indegree = new int[V];
        ///Get Indegrees
        for(int i=0;i<V;i++){
            for(int k:adj.get(i)){
                indegree[k]++;
            }
        }

        ///Add all with 0 to the queue
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }

        }
        int[] topoArr = new int[V];
        int i=0;
        ///Add all with 0 to topoL
        while(!q.isEmpty()){
            int node = q.poll();
            topoArr[i++] = node;

            for(int k: adj.get(node)){
                indegree[k]--;
                if(indegree[k]==0){
                    q.add(k);
                }
            }
        }
        return topoArr;

    }


    static void topoDFS(int src, ArrayList<ArrayList<Integer>> adj,Stack<Integer> stack,int[] visited){
        visited[src] = 1;
        for(int k : adj.get(src)){
            if(visited[k]==0){
                topoDFS(k,adj,stack,visited);
            }
        }
        stack.add(src);
    }

    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[V];

        for(int i=0;i<V;i++){
            if(visited[i]==0){
                topoDFS(i,adj,stack,visited);
            }
        }

        int[] ans = new int[V];
        int k = 0;
        while(!stack.isEmpty()){
            ans[k++] = stack.peek();
            stack.pop();
        }

        return ans;
    }
}
