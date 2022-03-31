import java.util.*;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {

        Queue<int[]> q = new PriorityQueue<int[]>(
                (p1, p2) -> Integer.compare((p2[0] * p2[0] + p2[1] * p2[1]), (p1[0] * p1[0] + p1[1] * p1[1])));

        for (int i = 0; i < points.length; i++) {
            q.add(points[i]);
            if (q.size() > k) {
                q.poll();
            }
        }
        int[][] arr = new int[k][2];
        while (k > 0) {
            arr[--k] = q.poll();
        }
        return arr;
    }
}
