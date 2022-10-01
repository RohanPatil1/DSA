import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberDistinctIslands {


    public void dfsTraversal(int row,int col,int[][] grid,int[][] visited, List<String> list,int row0, int col0){

        int n = grid.length;
        int m = grid[0].length;

        int pp = row - row0;
        int qq =col - col0;
        list.add(pp + qq + "");
        visited[row][col] = 1;

        for(int delR=-1; delR<=1; delR++){
            for(int delC = -1; delC<=1; delC++){

                int nRow = row + delR;
                int nCol = col + delC;

                if(nRow>=0 && nCol>=0 && nRow<n && nCol<m && grid[nRow][nCol]==1 && visited[nRow][nCol]==0){
                    dfsTraversal(nRow,nCol,grid,visited, list,row0, col0);
                }

            }
        }



    }
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int count = 0;

        Set<List<String>> set = new HashSet<>();


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(visited[i][j]==0 && grid[i][j]==1){

                    List<String> list = new ArrayList<>();
                    dfsTraversal(i,j,grid,visited,list,i,j);
                    count++;
                }


            }
        }

        return set.size();
    }
}
