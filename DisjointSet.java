public class DisjointSet {

    static int[] parent = new int[8];
    static int[] height = new int[8];


    public static void createSet(int n) {
        //Every parent is himself & height 0
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            height[i] = 0;
        }
    }


    public static int findParent(int node) {
        if (node == parent[node]) {
            return node;
        }

        return parent[node] = node;
    }


    public static void union (int node1,int node2) {
        node1 = findParent(node1);
        node2 = findParent(node2);

        if(height[node1] < height[node2]){
            //node1->node2
            parent[node1] = node2;
        }else if(height[node1] > height[node2]){
            //node2->node1
            parent[node2] = node1;
        }else{
            //== height so any
            parent[node2] = node1;
            height[node1] +=1;
        }
    }

    public static void main(String[] args) {
        createSet(7);
        union(1,2);
        union(2,3);
        union(4,5);
        union(6,7);
        union(5,6);
        union(3,7);
        for(int x:height){
            System.out.println(x);
        }
    }

}
