import java.util.ArrayList;
import java.util.List;

public class NumberOfIsland2 {

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {

        List<Integer> ansList = new ArrayList<>();

        int count = 0;
        int[][] visited = new int[rows][cols];

        DisjointSet.UF uf = new DisjointSet.UF(rows*cols);


        int[] delR = new int[]{-1, 0, 1, 0};
        int[] delC = new int[]{0, 1, 0, -1};

        for(int[] currOp : operators){
            int parentRow = currOp[0];
            int parentCol = currOp[1];

            if(visited[parentRow][parentCol] == 1){
                ansList.add(count);
                continue;
            }

            visited[parentRow][parentCol] = 1;
            count++;

            //Traverse in 4 direction
            for(int k=0; k<4; k++){

                int adjRow = parentRow + delR[k];
                int adjCol = parentCol + delC[k];

                boolean isBound = adjRow>=0 && adjRow<rows && adjCol>=0 && adjCol<cols;

                if(isBound && visited[adjRow][adjCol] == 1){ // is it actually an island then connect
                    int parentNode = parentRow*cols + parentCol;
                    int adjNode = adjRow*cols + adjCol;

                    if(uf.find(parentNode) != uf.find(adjNode)){ //we can connect
                        count--;
                        uf.union(parentNode, adjNode);
                    }

                }

            }
            ansList.add(count);

        }
        return ansList;
    }

}
