import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class MinimumEdges {
    //https://practice.geeksforgeeks.org/problems/minimum-edges/1
    static class Pair{
        int node;
        int distance;

        public Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }

    public static int minimumEdgeReversal(int[][] edges, int n, int m, int src, int dst) {

        List<List<Pair>> adj = new ArrayList<>();

        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], 0));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], 1));
        }


        int[] distance = new int[n +1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));


        while(!q.isEmpty()){
            Pair currP = q.poll();
            int parentNode = currP.node;
            int parentDistance = currP.distance;

            if(parentNode == dst) return distance[dst];

            for(Pair adjN : adj.get(parentNode)){
                int adjNode = adjN.node;
                int adjDistance = adjN.distance;

                if(parentDistance + adjDistance < distance[adjNode]){
                    distance[adjNode] = parentDistance + adjDistance;
                    q.add(new Pair(adjNode, distance[adjNode]));
                }

            }

        }

        return distance[dst];

    }

}
