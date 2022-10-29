import java.util.HashSet;
import java.util.Set;

public class MakingaLargeIsland {

    //time=N*M space=n*m
    public int MaxConnection(int grid[][]) {
        int n = grid.length, m = grid[0].length;
        DisjointSet.UF uf = new DisjointSet.UF(n * m);

        int[] delR = new int[]{-1, 0, 1, 0};
        int[] delC = new int[]{0, 1, 0, -1};

        //Create & connect all the connected components of 1s
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 0) continue;

                //Traverse in 4 directions & connect
                //T=n*m*4
                for (int k = 0; k < 4; k++) {
                    int adjRow = row + delR[k];
                    int adjCol = col + delC[k];

                    boolean isBound = adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < m;

                    if (isBound && grid[adjRow][adjCol] == 1) {
                        int node1 = row * m + col;
                        int node2 = adjRow * m + adjCol;
//                        if (uf.find(node1) != uf.find(node2)) {
//                            uf.union(node1, node2);
//                        }
                        uf.union(node1, node2);
                    }
                }
            }
        }
        int maxSize = Integer.MIN_VALUE;
        Set<Integer> parentSet = new HashSet<>();

        //Check for all zeros
        //uf.find might take logn but its negligible since its just 4 directions So n*m*4
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 1) continue;

                //Traverse in 4 directions & get all the parents it can connect to
                for (int k = 0; k < 4; k++) {
                    int adjRow = row + delR[k];
                    int adjCol = col + delC[k];

                    boolean isBound = adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < m;

                    if (isBound && grid[adjRow][adjCol] == 1) {
                        int node = adjRow * m + adjCol;
                        parentSet.add(uf.find(node));
                    }
                }
                int currSize = 0;
                for (int parent : parentSet) {
                    currSize += uf.getSizeAt(parent);
                }
                maxSize = Math.max(maxSize, currSize + 1);
                parentSet.clear();
            }
        }


        //If all cells are 1 just get the parent's size
        for (int i = 0; i < n * m; i++) {
            maxSize = Math.max(maxSize, uf.getSizeAt(uf.find(i)));
        }

        return maxSize;
    }
}
