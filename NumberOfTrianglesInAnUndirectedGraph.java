public class NumberOfTrianglesInAnUndirectedGraph {

    public static int getTriangles(int[][] graph, int V, boolean isDirected) {

        int triangleCount = 0;

        //if there is edge btw i-j, j-k , k-i then forms a triangle

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < V; k++) {
                    if (graph[i][j] == 1 && graph[j][k] == 1 && graph[k][i] == 1) {
                        triangleCount++;
                    }
                }
            }
        }

        //for undirected graph, we get 6 triangles which is actually 1
        if (!isDirected) triangleCount /= 6;
        else triangleCount /= 3;

        return triangleCount;
    }
}
