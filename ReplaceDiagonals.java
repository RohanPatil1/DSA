import java.util.*;

public class ReplaceDiagonals {

    private static int[][] directions = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 },
            { 1, -1 }, { 0, -1 } };

    public static List<Integer> getSurroundings(int[][] matrix, int x, int y) {
        List<Integer> res = new ArrayList<Integer>();
        for (int[] direction : directions) {
            int cx = x + direction[0];
            int cy = y + direction[1];
            if (cy >= 0 && cy < matrix.length)
                if (cx >= 0 && cx < matrix[cy].length)
                    res.add(matrix[cy][cx]);
        }
        return res;
    }

    public static int[][] ReplaceDiagonal(int[][] arr, int m) {
        int[][] ans = arr;

        int i, j;
        for (i = 0; i < m; i++) {
            for (j = 0; j < m; j++) {
                if (i == j) {
                    List<Integer> surr = getSurroundings(arr, i, j);
                    int tempSum = 0;
                    for (int k = 0; k < surr.size(); k++) {
                        tempSum += surr.get(k);
                    }
                    ans[i][j] = tempSum;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        // int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int a[][] = { { 18, 10 } };
        System.out.println(getSurroundings(a, 0, 0));

        // int a[][]={{1,3,4},{2,4,3},{3,4,5}};
        // System.out.println(getSurroundings(a, 0, 0));
        int[][] mat = ReplaceDiagonal(a, 1);
        int m = 1;

        System.out.println("The elements of the matrix");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println("");
        }

    }

}
