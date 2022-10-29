import java.util.HashMap;
import java.util.Map;

public class MostStonesRemoved {

    public static int maxRemove(int[][] stones, int n) {

        int maxRows = 0;
        int maxCols = 0;
        for (int i = 0; i < n; i++) {
            maxRows = Math.max(maxRows, stones[i][0]);
            maxCols = Math.max(maxCols, stones[i][1]);
        }

        DisjointSet.UF uf = new DisjointSet.UF(maxRows + maxCols);


        //We need the unique parents
        Map<Integer, Integer> stoneNodesMap = new HashMap<>();

        for (int[] stone : stones) {
            int nodeRow = stone[0];
            int nodeCol = stone[1] + maxRows + 1;

            //Connect
            uf.union(nodeRow, nodeCol);

            stoneNodesMap.put(nodeRow, 1);
            stoneNodesMap.put(nodeCol, 1);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : stoneNodesMap.entrySet()) {
            //Number of parents i.e parent is self
            if (uf.find(entry.getKey()) == entry.getValue()) {
                count++;
            }
        }

        return n - count;
    }

}
