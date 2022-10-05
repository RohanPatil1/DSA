import java.util.Queue;
import java.util.LinkedList;

public class AsFarFromLandAsPossible {

    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

    public int maxDistance(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        Queue<Pair> q = new LinkedList<>();

        //Add all land to queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                }

            }
        }


        //Start traversal

        int level = -1;
        int[] delR = new int[]{-1, 0, 1, 0};
        int[] delC = new int[]{0, 1, 0, -1};

        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            for (int l = 0; l < size; l++) {

                Pair currP = q.poll();
                int currRow = currP.row;
                int currCol = currP.col;

                for (int d = 0; d < 4; d++) {
                    int nRow = currRow + delR[d];
                    int nCol = currCol + delC[d];

                    boolean isBound = nRow < 0 || nRow >= n || nCol < 0 || nCol >= m;
                    if (isBound || grid[nRow][nCol] == 1 || visited[nRow][nCol] == 1) continue;

                    q.add(new Pair(nRow, nCol));
                    visited[nRow][nCol] = 1;
                }

            }

        }


        if (level == 0) return -1;

        return level;

    }


}
