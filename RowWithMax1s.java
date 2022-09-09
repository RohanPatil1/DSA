public class RowWithMax1s {


    public static int rowWithMax1s(int[][] grid) {
        int row = -1;

        int n = grid.length;
        int m = grid[0].length;

        int j = m - 1;
        boolean flag = false;


        for (int i = 0; i < n; i++) {

            flag = false;
            while (j >= 0 && grid[i][j] == 1) {
                flag = true;
                j--;
            }

            if (flag)
                row = i;

        }
        return -1;
    }
}
