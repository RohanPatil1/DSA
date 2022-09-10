import java.util.ArrayList;

public class CycleDirectedGraph {


    public boolean detectDFS(int src,ArrayList<ArrayList<Integer>> adj,int[] visited,int[] pathVisited){

        visited[src]  = 1;
        pathVisited[src] = 1;

        //Traverse All Nodes
        for(int k: adj.get(src)){

            //If Not Visited
            if(visited[k]==0){

                if(detectDFS(k,adj,visited,pathVisited)){
                    return true;
                }
            }else{

                //If the node is previously visited

                //visited + pathVisited
                if(pathVisited[k]==1){
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


        for(int i=0;i<V;i++){
            if(visited[i]==0){
                if(detectDFS(i,adj,visited,pathVisited)) return true;
            }
        }

        return false;
    }

}
