import java.util.ArrayList;
import java.util.List;

public class JourneyToMoon {
    //Time = O(V+E) Space= O(V)
    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < astronaut.size(); i++) {
            adj.get(astronaut.get(i).get(0)).add(astronaut.get(i).get(1));
        }

        int[] visited = new int[n];
        List<Integer> groupings = new ArrayList<>();
        int[] counter = new int[1];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                counter[0] = 0;
                dfs(i, adj, visited, counter);
                groupings.add(counter[0]);
            }
        }

        //3 ,2
        int total = n * (n - 1) / 2;
        for (int num : groupings) {
            int group = groupings.get(0) * (groupings.get(0) - 1) / 2;
            total -= group;
        }

        return total;
    }

    private static void dfs(int src, List<List<Integer>> adj, int[] visited, int[] counter) {
        visited[src] = 1;
        counter[0]++;

        for (int k : adj.get(src)) {
            if (visited[k] == 0) {
                dfs(k, adj, visited, counter);
            }
        }

    }

}
