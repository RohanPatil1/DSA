public class MaxAreaIslandsGraph {

    public int dfs(int i, int j, int[][] grid, int[][] visited){

        int n = grid.length;
        int m = grid[0].length;

        if(i<0 || j<0 || i>=n || j>=m || visited[i][j] == 1 || grid[i][j]==0){
            return 0;
        }

        visited[i][j] = 1;


        return 1 + dfs(i-1,j,grid,visited) + dfs(i,j-1,grid,visited)+ dfs(i+1,j,grid,visited) + dfs(i,j+1,grid,visited);
    }


    public int maxAreaOfIsland(int[][] grid) {

        int n=grid.length;
        int m =grid[0].length;

        int[][] visited = new int[n][m];

        int maxArea = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] == 0 && grid[i][j] == 1){

                    int area =   dfs(i,j, grid, visited);


                    maxArea = Math.max(maxArea, area);

                }
            }

        }
        if(maxArea == Integer.MIN_VALUE) return 0;

        return maxArea;
    }
}
