import java.util.Arrays;

public class SmallestCommonElementinAllRows {

    ///LC 1198


    //Time = O(nm) Space=O(max-element)
    public static int sceRows(int[][] mat) {

        int[] freq = new int[10001];

        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                freq[mat[i][j]]++;
            }
        }

        //Check from start
        for (int i = 1; i < 10001; i++) {
            if (freq[i] == n) { // all rows have i
                return i;
            }
        }

        return -1;
    }


    //Time = O(n*m*logm) Space=O(1)
    public static int sceRowsBS(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        for (int j = 0; j < m; j++) {
            boolean isFound = true;

            for (int i = 1; i < n && isFound; i++) {
                isFound = Arrays.binarySearch(mat[i], mat[0][j]) >= 0;
            }

            if (isFound) return mat[0][j];
        }

        return -1;
    }


}
