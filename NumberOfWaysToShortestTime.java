import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfWaysToShortestTime {



    static class Pair{
        int node;
        int time;

        public Pair(int node, int time){
            this.node = node;
            this.time = time;
        }
    }

    static int countPaths(int n, List<List<Integer>> roads) {

        int mod =(int) 1e9 + 7;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int m = roads.size();
        for(int i=0;i<m;i++){
            adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1), roads.get(i).get(2)));
            //Since bidirectional
            adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0), roads.get(i).get(2)));
        }

        int[] timeArr = new int[n];
        int[] ways = new int[n];
        timeArr[0] = 0;
        ways[0] = 1;


        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y)->x.time - y.time);
        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair currP = pq.poll();
            int parentNode = currP.node;
            int parentTime = currP.time;


            for(Pair adjN: adj.get(parentNode)){
                int adjNode = adjN.node;
                int adjTime = adjN.time;


                //First time arriving with a short distance
                if(adjTime + parentTime < timeArr[adjNode]){
                    timeArr[adjNode] = adjTime + parentTime;
                    pq.add(new Pair(adjNode, timeArr[adjNode]));

                    ways[adjNode] = ways[parentNode];
                }else if(adjTime + parentTime == timeArr[adjNode]){
                    //It means we got another path with same distance/time
                    ways[adjNode] = (ways[adjNode] + ways[parentNode])%mod;

                }

            }

        }


        return ways[n-1];
    }
}
