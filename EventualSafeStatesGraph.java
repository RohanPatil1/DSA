import java.util.ArrayList;
import java.util.List;

public class EventualSafeStatesGraph {


    boolean detectCycle(int src,List<List<Integer>> adj,int[] visited,int[] pathVisited){


        visited[src]  = 1;
        pathVisited[src] = 1;

        //Traverse All Nodes
        for(int k: adj.get(src)){

            //If Not Visited
            if(visited[k]==0){

                if(detectCycle(k,adj,visited,pathVisited)){
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

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here


        int[] visited = new int[V];
        int[] pathV = new int[V];


        for(int i=0;i<V;i++){

            if(visited[i]==0){
                detectCycle(i,adj,visited,pathV);
            }

        }

        List<Integer> safeNodesList = new ArrayList<>();

        for(int i=0;i<V;i++){
            if(pathV[i]==0){
                safeNodesList.add(i);
            }
        }


        return safeNodesList;
    }

}
