import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class KosarajuAlgorithm {


    public static int scc(ArrayList<ArrayList<Integer>> adj, int n) {

        int[] visited = new int[n];
        Stack<Integer> stack = new Stack<>();
        int sccCount = 0;
        //Topo-Sort
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i, stack, adj, visited);
            }
        }
        //Now stack has topo sorted nodes

        Arrays.fill(visited, 0); //reset

        //Do transpose i.e reverse the graph edges
        ArrayList<ArrayList<Integer>> transposeAdj = getTranspose(adj, n);


        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (visited[node] == 0) {
                System.out.println("SCC: ");
                sccCount++;
                reverseDfs(node, transposeAdj, visited);
                System.out.println();
            }
        }

        return sccCount;
    }

    public static ArrayList<ArrayList<Integer>> getTranspose(ArrayList<ArrayList<Integer>> adj, int n) {

        ArrayList<ArrayList<Integer>> transposeAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            transposeAdj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int k : adj.get(i)) {
                transposeAdj.get(k).add(i);
            }


        }
        return transposeAdj;
    }

    private static void dfs(int src, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[src] = 1;

        for (int k : adj.get(src)) {
            if (visited[k] == 0) {
                dfs(k, stack, adj, visited);
            }
        }
        stack.push(src);
    }


    private static void reverseDfs(int src, ArrayList<ArrayList<Integer>> transposeAdj, int[] visited) {
        visited[src] = 1;
        System.out.println(src + " ");
        for (int k : transposeAdj.get(src)) {
            if (visited[k] == 0) {
                reverseDfs(k, transposeAdj, visited);
            }
        }

    }

}
