public class RedundantConnections {

    public int findParent(int node, int[] parent) {

        if (node == parent[node]) {
            return node;
        }

        return parent[node] = node;
    }

    public int[] findRedundantConnection(int[][] edges) {

        int[] parent = new int[10001];
        for (int i = 0; i < 1001; i++) {
            parent[i] = i;
        }

        int[] res = new int[2];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int p1 = findParent(u, parent);
            int p2 = findParent(v, parent);

            if (p1 == p2) {
                res = edge;
            }
            parent[p1] = p2;
        }

        return res;

    }
}
