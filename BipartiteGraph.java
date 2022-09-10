import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class BipartiteGraph {



    public boolean verifyDFS(int src,int srcColor , ArrayList<ArrayList<Integer>>adj , int[] color){

        color[src] = srcColor;

        for(int k:adj.get(src)){

            if(color[k] == -1){
                if(!verifyDFS(k, 1 - srcColor, adj, color)){
                    return false;
                }
            }else if(color[k]==srcColor){
                return false;
            }
        }
        return true;
    }


    public boolean verifyBFS(int src, ArrayList<ArrayList<Integer>>adj , int[] color){


        Queue<Integer> q = new LinkedList<>();
        color[src] = 0;
        q.add(src);


        while(!q.isEmpty()){
            int node = q.poll();
            int currColor = color[node];
            for(int k: adj.get(node)){

                if(color[k]==-1){

                    color[k] = (currColor==0)?1:0;
                    q.add(k);

                }else if(color[k]==currColor){
                    return false;

                }

            }

        }
        return true;

    }


    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here

        int[] color = new int[V];
        Arrays.fill(color,-1);


        for(int i=0;i<V;i++){

            if(color[i]==-1){

                if(verifyBFS(i,adj,color)==false){
                    return false;
                }


            }


        }



        return true;

    }
}
