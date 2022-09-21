import java.util.ArrayList;

public class BridgeInGraph {


    public static void getBridges(ArrayList<ArrayList<Integer>> adj, int n) {
        int[] visited = new int[n];
        int[] startTime = new int[n];
        int[] finishTime = new int[n];


        int timer = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i, -1, adj, visited, startTime, finishTime, timer);
            }
        }

    }

    private static void dfs(int src, int parent, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] startTime, int[] finishTime, int timer) {
        visited[src] = 1;
        startTime[src] = finishTime[src] = timer++;

        for (int k : adj.get(src)) {
            if (k == parent) continue;
            if (visited[k] == 0) {
                dfs(k, src, adj, visited, startTime, finishTime, timer);

                //Take lowest from self or adjacent
                startTime[src] = Math.min(startTime[src], startTime[k]);

                //If src doesn't have time smaller than k, src-k is bridge
                if (startTime[k] > finishTime[src]) {
                    System.out.println("Bridge " + k + "-" + src);
                }
            } else {
                startTime[src] = Math.min(startTime[src], finishTime[k]);
            }
        }
    }


}
