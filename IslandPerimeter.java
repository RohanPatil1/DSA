public class IslandPerimeter {


    int[] delR = new int[]{-1, 0, 1, 0};
    int[] delC = new int[]{0, 1, 0, -1};


    int dfs(int i, int j, int[][] grid, int[][] visited) {

        int perimeter = 0;
        grid[i][j] = -1;
        for (int k = 0; k < 4; k++) {

            int nRow = i + delR[k];
            int nCol = j + delC[k];

            if (nRow < 0 || nCol < 0 || nRow >= grid.length || nCol >= grid[0].length || grid[nRow][nCol] == 0) {
                perimeter++;
            } else {

                if (grid[nRow][nCol] == 1) {
                    perimeter += dfs(nRow, nCol, grid, visited);
                }

            }

        }


        return perimeter;
    }

    public int islandPerimeter1(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int[][] visited = new int[n][m];

        int ansPerimeter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    ansPerimeter = dfs(i, j, grid, visited);
                }

            }
        }

        return ansPerimeter;
    }

    ///Iterative
    public int islandPerimeter2(int[][] grid) {
        int n = grid.length, m = grid[0].length;


        int ansPerimeter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    //Travel in 4 directions

                    for (int k = 0; k < 4; k++) {
                        int nRow = i + delR[k];
                        int nCol = j + delC[k];

                        if (nRow < 0 || nCol < 0 || nRow >= n || nCol >= m || grid[nRow][nCol] == 0) {
                            ansPerimeter++;
                        }

                    }
                }

            }
        }

        return ansPerimeter;
    }
}
