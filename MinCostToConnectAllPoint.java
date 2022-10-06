import java.util.PriorityQueue;

public class MinCostToConnectAllPoint {

    //This edge will tell from which node to which node i am connected and what's its cost
    class Edge {
        int point1;
        int point2;
        int cost;

        public Edge(int point1, int point2, int cost) {
            this.point1 = point1;
            this.point2 = point2;
            this.cost = cost;
        }
    }

    public int minCostConnectPointsWithPrims(int[][] points) {
        int minCost = 0;
        int n = points.length;

        if (points == null || points.length == 0)
            return 0;

        int[] visited = new int[n];

        int reqEdges = n - 1;
        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> x.cost - y.cost);

        int[] point1Coordinate = points[0];

        for (int i = 1; i < n; i++) {
            int[] point2Coordinate = points[i];
            int cost = Math.abs(point2Coordinate[0] - point1Coordinate[0]) + Math.abs(point2Coordinate[1] - point1Coordinate[1]);

            Edge e = new Edge(0, i, cost);
            pq.add(e);
        }

        visited[0] = 1;

        while (!pq.isEmpty() && reqEdges > 0) {
            Edge edge = pq.poll();
            int point1 = edge.point1;
            int point2 = edge.point2;
            int cost = edge.cost;

            if (visited[point2] == 1) continue;

            minCost += cost;
            visited[point2] = 1;

            //Explore from point2 to other points
            for (int i = 0; i < n; i++) {
                if (visited[i] == 1) continue;
                int distance = Math.abs(points[point2][0] - points[i][0])
                        + Math.abs(points[point2][1] - points[i][1]);

                pq.add(new Edge(point2, i, distance));
            }

            reqEdges--;
        }

        return minCost;
    }


}
