import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffortGraph {

    class Pair {
        int distance;
        int row;
        int column;

        public Pair(int distance, int row, int column) {
            this.distance = distance;
            this.row = row;
            this.column = column;
        }
    }

    int minimumEffort(int heights[][]) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[][] distance = new int[n][m]; //will store the difference

        for (int[] d : distance) Arrays.fill(d, Integer.MAX_VALUE);

        //{difference=distance, row, column}
        pq.add(new Pair(0, 0, 0));
        distance[0][0] = 0;

        int[] delR = new int[]{-1, 0, 1, 0};
        int[] delC = new int[]{0, 1, 0, -1};

        while (!pq.isEmpty()) {
            Pair currP = pq.poll();
            int currDiff = currP.distance;
            int currRow = currP.row;
            int currCol = currP.column;

            if (currRow == n - 1 && currCol == m - 1) return currDiff;

            //Traverse in 4 direction
            for (int i = 0; i < 4; i++) {
                int nRow = currRow + delR[i];
                int nCol = currCol + delC[i];

                boolean isBound = nRow >= 0 && nRow < n && nCol >= 0 && nCol < m;
                if (isBound) {
                    int effortFromPosition = Math.abs(heights[currRow][currCol] - heights[nRow][nCol]);
                    int newEffort = Math.max(effortFromPosition, currDiff);

                    if (newEffort < distance[nRow][nCol]) {
                        distance[nRow][nCol] = newEffort;
                        pq.add(new Pair(distance[nRow][nCol], nRow, nCol));
                    }

                }

            }


        }

        //Not Reachable
        return 0;

    }
}
