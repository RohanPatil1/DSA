import java.util.*;

class RotateImage {

    public void rotate(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        // Find the transpose
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Swap a[i][j] => a[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Reverse Row By Row
        for(int[] row:matrix){
            Collections.reverse(Arrays.asList(row));
        }


    }

    public static void main(String[] args) {

    }
}