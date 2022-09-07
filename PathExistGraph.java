import java.util.ArrayList;

public class PathExistGraph {


    public static int isPossible(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int a = 0, b = 0, tX = 0, tY = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    a = i;
                    b = j;
                }

                if (grid[i][j] == 2) {
                    tX = i;
                    tY = j;
                }
            }
        }


        solve(grid, visited, a, b);
        return visited[tX][tY];
    }

    private static void solve(int[][] grid, int[][] visited, int a, int b) {
        if (a < 0 || b < 0 || a >= grid.length || b >= grid.length || visited[a][b] == 1 || grid[a][b] == 0) return;

        visited[a][b] = 1;
        solve(grid, visited, a + 1, b);
        solve(grid, visited, a - 1, b);
        solve(grid, visited, a, b + 1);
        solve(grid, visited, a, b - 1);
    }

    //-------------Without visited
    public static boolean isPossible2(int[][] grid) {

        int r = -1, c = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    r = i;
                    c = j;
                    break;
                }
            }
            if (r != -1) break;
        }

        return dfsSolver(grid, r, c);
    }

    private static boolean dfsSolver(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) return false;

        if (grid[r][c] == 2) return true;

        grid[r][c] = 0;
        return dfsSolver(grid, r + 1, c) || dfsSolver(grid, r - 1, c) || dfsSolver(grid, r, c + 1) || dfsSolver(grid, r, c - 1);
    }
}
