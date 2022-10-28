public class NumberOfProvinces {


    public int findCircleNum(int[][] isConnected) {

        int V = isConnected.length;

        DisjointSet ds = new DisjointSet(V);

        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){

                if(isConnected[i][j] == 1){
                    ds.union(i, j);
                }

            }
        }

        int count = 0;
        for(int i=0; i<V; i++){
            if(ds.findParent(i) == i) count++;
        }


        return count;
    }

}
