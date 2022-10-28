public class DisjointSet {

    static int[] parent = new int[8];
    static int[] rank = new int[8];
    static int[] size = new int[8];

    public DisjointSet(int V){
        //Every parent is himself & height 0
        for (int i = 0; i <V; i++) {
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }
    public static void createSet(int n) {
        //Every parent is himself & height 0
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }

    public static int findParent(int node) {
        if (node == parent[node]) {
            return node;
        }

        return parent[node] = findParent(parent[node]);
    }


    public static void union(int node1, int node2) {
        int node1UP = findParent(node1); //ultimate parent of node1
        int node2UP = findParent(node2); //ultimate parent of node2

        if (node1UP == node2UP) return;

        if (rank[node1UP] < rank[node2UP]) {
            //node1->node2
            parent[node1UP] = node2UP;
        } else if (rank[node1UP] > rank[node2UP]) {
            //node2->node1
            parent[node2UP] = node1UP;
        } else {
            //== rank so any
            parent[node2UP] = node1UP;
            rank[node1UP] += 1;
        }
    }

    public static void unionBySize(int node1, int node2) {
        int node1UP = findParent(node1); //ultimate parent of node1
        int node2UP = findParent(node2); //ultimate parent of node2

        if (node1UP == node2UP) return;

        if (size[node1UP] < size[node2UP]) {
            //node1->node2
            parent[node1UP] = node2UP;
            size[node2UP] += size[node1UP];
        } else { //both cases combined
            //node2->node1
            parent[node2UP] = node1UP;
            size[node1UP] += size[node2UP];
        }
    }

    public static void main(String[] args) {
        createSet(7);
        union(1, 2);
        union(2, 3);
        union(4, 5);
        union(6, 7);
        union(5, 6);
        union(3, 7);
        for (int x : rank) {
            System.out.println(x);
        }
    }


    static class UF {
        private int[] parent, size;
        private int count;

        public UF(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }

        }

        public int find(int node) {
            if (node == parent[node]) {
                return node;
            }

            return parent[node] = find(parent[node]);
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;
            // union by size
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public int count() { return count; }
    }


}
