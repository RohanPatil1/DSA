import java.util.*;

public class NetworkDelayTime {

    class Pair {
        int node;
        int cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Node:" + node + " Cost:" + cost;
        }
    }


    public int networkDelayTime(int[][] times, int n, int k) {
        int minTime = 0;
        Map<Integer, List<Pair>> adj = new HashMap<>();

        for (int[] time : times) {
            int u = time[0], v = time[1], cost = time[2];
            if (!adj.containsKey(u)) {
                adj.put(u, new ArrayList<>());
            }
            adj.get(u).add(new Pair(v, cost));
        }


        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.cost - y.cost);
        Set<Integer> visitedSet = new HashSet<>();

        pq.add(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair currP = pq.poll();
            int parentNode = currP.node;
            int parentCost = currP.cost;

            if (visitedSet.contains(parentNode)) continue;

            minTime = parentCost;
            visitedSet.add(parentNode);

            if (!adj.containsKey(parentNode)) continue;

            for (Pair adjN : adj.get(parentNode)) {
                int adjNode = adjN.node;
                int adjCost = adjN.cost;
                pq.add(new Pair(adjNode, adjCost + parentCost));
            }
        }

        return visitedSet.size() == n ? minTime : -1;
    }

    public int networkDelayTime2(int[][] times, int n, int k) {
        int minTime = 0;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int cost = time[2];

            adj.get(u).add(new Pair(v, cost));

        }


        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.cost - y.cost);
        Set<Integer> visitedSet = new HashSet<>();

        pq.add(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair currP = pq.poll();
            int parentNode = currP.node;
            int parentCost = currP.cost;

            if (visitedSet.contains(parentNode)) continue;

            minTime = parentCost;
            visitedSet.add(parentNode);

            if (parentNode>=adj.size()  || adj.get(parentNode).isEmpty()) continue;

            for (Pair adjN : adj.get(parentNode)) {
                int adjNode = adjN.node;
                int adjCost = adjN.cost;
                pq.add(new Pair(adjNode, adjCost + parentCost));
            }
        }

        return visitedSet.size() == n ? minTime : -1;
    }

}
