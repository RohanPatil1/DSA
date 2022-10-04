import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticOcean {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n = heights.length;
        int m= heights[0].length;

        int[][] pacific = new int[n][m];
        int[][] atlantic = new int[n][m];


        //Top & bottom
        for(int i=0;i<n;i++){
            dfs(heights, i, 0, pacific, Integer.MIN_VALUE);
            dfs(heights, i, m-1, atlantic, Integer.MIN_VALUE);
        }


        //Left & right
        for(int i=0;i<m;i++){
            dfs(heights, 0, i, pacific, Integer.MIN_VALUE);
            dfs(heights, n-1, i, atlantic, Integer.MIN_VALUE);
        }

        List<List<Integer>> pointList = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(pacific[i][j]==1 && atlantic[i][j]==1){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    pointList.add(list);
                }

            }
        }

        return pointList;

    }

    void dfs(int[][] matrix,int row, int col, int[][] ocean, int prev){

        if(row<0 || col<0 || row>=matrix.length || col >= matrix[0].length) return;

        if(matrix[row][col] < prev) return;

        if(ocean[row][col]==1) return;


        ocean[row][col] = 1;


        dfs(matrix, row-1, col, ocean, matrix[row][col]);
        dfs(matrix, row+1, col, ocean, matrix[row][col]);
        dfs(matrix, row, col+1, ocean, matrix[row][col]);
        dfs(matrix, row, col-1, ocean, matrix[row][col]);

    }
}
