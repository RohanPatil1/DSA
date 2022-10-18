import java.util.ArrayList;

public class RatInMaze {

    //Time Com= Exponential O(4^(n^2))
    public static void dfs(int row, int col, int[][] mat, String currPath, ArrayList<String> pathList){

        if(row<0 || col<0 || row>=mat.length || col>=mat[0].length || mat[row][col]==0){
            return;
        }

        if(row == mat.length-1 && col == mat[0].length-1){

            pathList.add(new String(currPath));
            return;
        }


        int temp = mat[row][col];
        mat[row][col] = 0;
        dfs(row + 1, col, mat, currPath + "D", pathList);
        dfs(row - 1, col, mat, currPath + "U", pathList);
        dfs(row, col - 1, mat, currPath + "L", pathList);
        dfs(row, col + 1, mat, currPath + "R", pathList);


        mat[row][col] = temp;
    }


    public static ArrayList<String> findPath(int[][] mat, int n) {

        int m = mat[0].length;

        int[][] visited = new int[n][m];

        ArrayList<String> pathList = new ArrayList<>();

        dfs(0, 0, mat, "", pathList);


        return pathList;

    }

}
