import java.util.LinkedList;
import java.util.Queue;


/*
You are given a m x n 2D grid initialized with these three possible values.
-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
  */


public class WallAndGates {

    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


    private void dfs(int i, int j, int distance, int[][] rooms) {
        if (i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length) {
            return;
        }

        rooms[i][j] = distance;

        dfs(i + 1, j, distance + 1, rooms);
        dfs(i - 1, j, distance + 1, rooms);
        dfs(i, j + 1, distance + 1, rooms);
        dfs(i, j - 1, distance + 1, rooms);

    }

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();
        int m = rooms.length;
        int n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) q.add(new int[]{i, j});
            }
        }

        if (q.size() == 0) return;
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];
            for (int[] dir : dirs) {
                int x = row + dir[0];
                int y = col + dir[1];
                if (
                        x >= m ||
                                y >= n ||
                                x < 0 ||
                                y < 0 ||
                                rooms[x][y] != Integer.MAX_VALUE
                ) continue;
                q.add(new int[]{x, y});
                //since cur is basically the index of door (which is equal to 0)
                //So, we can just grab that value (rooms[row][col]) and add 1 to it and change it every time
                rooms[x][y] = rooms[row][col] + 1;
                //So, one level further from door (value 0) is equal to 1. Now, we do bfs from that position so value will be 2 and so on.
            }
        }
    }

    //Using BFS
    public void wallsAndGates2(int[][] rooms) {
        int n = rooms.length;
        int m = rooms[0].length;
        Queue<Pair> q = new LinkedList<>();

        //Add all gates to queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new Pair(i, j));
                }
            }
        }

        int[] delR = new int[]{-1, 0, 1, 0};
        int[] delC = new int[]{0, 1, 0, -1};

        //BFS
        while (!q.isEmpty()) {
            Pair currP = q.poll();
            int row = currP.row;
            int col = currP.col;

            //Traverse in 4 direction
            for (int i = 0; i < 4; i++) {
                int nRow = row + delR[i];
                int nCol = col + delC[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && rooms[nRow][nCol] != Integer.MAX_VALUE) {
                    q.add(new Pair(nRow, nCol));
                    rooms[nRow][nCol] = rooms[row][col] + 1;
                }

            }

        }

    }

}
