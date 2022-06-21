import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {


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
        System.out.println("Nos of 2 : "+q.size());
        int count = 0;
        q.offer(new MyPair(-1, -1)); //Divider

        while (!q.isEmpty()) {
            int i = q.peek().diff;
            int j = q.peek().ele;

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
    public static void main(String[] args) {
        int[][] p = new int[][]{{0,1,2},{0,1,2},{2,1,1}};
        System.out.println(orangesRotting(p));
    }
}
