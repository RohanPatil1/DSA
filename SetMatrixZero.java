import java.util.HashMap;
import java.util.Map;

public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {

        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> columnMap = new HashMap<>();

        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == 0) {

                    rowMap.put(i, 0);
                    columnMap.put(j, 0);
                }


            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                boolean shouldRowZero = rowMap.containsKey(i) && rowMap.get(i) == 0;

                boolean shouldColumnZero = columnMap.containsKey(j) && columnMap.get(j) == 0;

                if (shouldRowZero || shouldColumnZero) {
                    matrix[i][j] = 0;
                }


            }

        }

    }
}
