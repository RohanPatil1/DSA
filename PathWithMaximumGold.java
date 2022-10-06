public class PathWithMaximumGold {

   /*
        the problem is that we use visited[][] we have to make it false again after every path. Rather than this,
        we can put it as 0 for a particular path & then after completion i.e while going back, we will reset it
        to the original value. This way for the next path, the matrix will be in default state.

        So at the end after completion, the matrix will be as it was before calling dfs!
        And we are calculating maxGold when we reached the base condition i.e path end.

    */

    int maxGold = 0;

    public int getMaximumGold(int[][] grid) {


        int n = grid.length;
        int m = grid[0].length;


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if(grid[i][j] != 0){
                    dfs(i, j, grid, 0);
                }
            }
        }




        printMatrix(grid);


        return maxGold;
    }

    public void dfs(int row, int col, int[][] grid, int currGold){
        if(row<0 || col<0 || row >=grid.length || col>=grid[0].length || grid[row][col]==0){

            maxGold = Math.max(maxGold, currGold);
            return ;

        }


        int temp = grid[row][col];

        grid[row][col] = 0;

        dfs(row + 1, col, grid, currGold + temp);
        dfs(row - 1, col, grid, currGold + temp);
        dfs(row, col + 1, grid, currGold + temp);
        dfs(row, col - 1, grid, currGold + temp);

        grid[row][col] = temp;
    }

    public  void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

}
