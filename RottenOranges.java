import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    static class OPair {
        int row;
        int col;
        int time;

        public OPair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static int orangesRotting(int[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;

        Queue<MyPair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new MyPair(i, j));
                }
            }
        }
        System.out.println("Nos of 2 : " + q.size());
        int count = 0;
        q.offer(new MyPair(-1, -1)); //Divider

        while (!q.isEmpty()) {
            int i = q.peek().a;
            int j = q.peek().b;

            if (i == -1 && j == -1 && q.size() == 1) {
                q.poll();
                System.out.println("BREAK");

                break;
            } else if (i == -1 && j == -1 && q.size() > 1) {
                //i section complete now go to next section
                count++; //Store the iteration count i.e ans
                System.out.println(count);
                q.poll(); //remove (-1,-1)
                //Add another divider and the end of the current section
                q.offer(new MyPair(-1, -1));
            } else {
                //Not -1,-1 but some other index pair of value 2
                //So we ROT

                if ((i - 1) >= 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    q.offer(new MyPair(i - 1, j));
                }
                if ((j - 1) >= 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    q.offer(new MyPair(i, j - 1));
                }
                if ((i + 1) < n && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    q.offer(new MyPair(i + 1, j));
                }
                if ((j + 1) < m && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    q.offer(new MyPair(i, j + 1));
                }
                //store 2 - rot 1 - ignore 0
                q.poll();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return count;
    }


    public int orangesRottingBFS(int[][] grid) {

        int freshCount = 0;
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        Queue<OPair> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){

                if(grid[i][j]==2){
                    visited[i][j] = 1;
                    q.offer(new OPair(i,j,0));
                }else{
                    visited[i][j] = 0;
                }

                if(grid[i][j]==1) freshCount++;

            }
        }

        int countRot = 0;
        int ansTime = 0;
        ///BFS
        while(!q.isEmpty()){

            OPair currP = q.poll();
            int row = currP.row;
            int col = currP.col;
            int time = currP.time;
            ansTime = Math.max(ansTime,time);
            //Rot neightbouring oranges
            int[] delR = new int[]{-1,0,1,0};
            int[] delC = new int[]{0,1,0,-1};


            for(int i=0;i<4;i++){
                int nRow = row + delR[i];
                int nCol = col + delC[i];

                //If its in bounds & not visited & fresh
                boolean isBounds = nRow>=0 && nRow<n && nCol>=0 && nCol<m;

                if(isBounds && grid[nRow][nCol]==1 && visited[nRow][nCol]==0){

                    visited[nRow][nCol] = 1;
                    q.offer(new OPair(nRow,nCol,time + 1));
                    countRot++;
                }

            }

        }
        if(countRot!=freshCount) return -1;

        return ansTime;
    }

    public static void main(String[] args) {
        int[][] p = new int[][]{{0, 1, 2}, {0, 1, 2}, {2, 1, 1}};
        System.out.println(orangesRotting(p));
    }
}
