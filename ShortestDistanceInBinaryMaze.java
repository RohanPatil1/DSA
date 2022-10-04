import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInBinaryMaze {

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

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        int n = grid.length;
        int m = grid[0].length;
        if(source[0]==destination[0] && source[1] == destination[1]){
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        int[][] distance = new int[n][m];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source[0]][source[1]] = 0;
        q.add(new Pair(0, source[0], source[1]));


        while (!q.isEmpty()) {
            Pair currP = q.poll();
            int parentDistance = currP.distance;
            int parentRow = currP.row;
            int parentCol = currP.column;

            int[] delR = new int[]{-1, 0, 1, 0};
            int[] delC = new int[]{0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int nRow = parentRow + delR[i];
                int nCol = parentCol + delC[i];

                boolean isBound = nRow >= 0 && nRow < n && nCol >= 0 && nCol < m;

                if (isBound && grid[nRow][nCol] == 1 && parentDistance + 1 < distance[nRow][nCol]) {
                    distance[nRow][nCol] = 1 + parentDistance;
                    if (nRow == destination[0] && nCol == destination[1]) {
                        return distance[nRow][nCol];
                    }
                    q.add(new Pair(distance[nRow][nCol], nRow, nCol));

                }

            }
        }
        return -1;
    }

}
