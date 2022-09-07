import java.util.LinkedList;
import java.util.Queue;

public class NumberIslandsGraph {

    static class BPair {
        int first;
        int second;

        BPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    //Using BFS
    public static int noOfIslands(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int count = 0;

        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] != 0 && grid[i][j] == 1) {
                    count++;
                    dfsTraversal(i, j, grid, visited);
                }
            }
        }

        return count;
    }

    private static void dfsTraversal(int row, int col, int[][] grid, int[][] visited) {
        int n = grid.length;
        int m = grid[0].length;

        visited[row][col] = 1;
        for (int delR = -1; delR <= 1; delR++) {
            for (int delC = -1; delC <= 1; delC++) {

                int nRow = row + delR;
                int nCol = row + delC;

                if (nRow >= 0 && nCol >= 0 && nRow < n && nCol < m && grid[nRow][nCol] == '1' && visited[nRow][nCol] == 0) {
                    dfsTraversal(nRow, nCol, grid, visited);
                }
            }
        }

    }

    private static void bfsTraversal(int row, int col, int[][] grid, int[][] visited) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<BPair> queue = new LinkedList<>();

        //Insert source
        visited[row][col] = 1;
        queue.offer(new BPair(row, col));

        while (!queue.isEmpty()) {

            BPair currP = queue.poll();
            int currRow = currP.first;
            int currCol = currP.second;

            //Traverse 8 directions
            for (int delR = -1; delR <= 1; delR++) {
                for (int delC = -1; delC <= 1; delC++) {

                    int nRow = currRow + delR;
                    int nCol = currCol + delC;

                    if (nRow >= 0 && nCol >= 0 && nRow < n && nCol < m && grid[nRow][nCol] == '1' && visited[nRow][nCol] == 0) {
                        visited[nRow][nCol] = 1;
                        queue.offer(new BPair(nRow, nCol));
                    }
                }
            }
        }
    }


}
