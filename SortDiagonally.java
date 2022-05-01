import java.util.*;
public class SortDiagonally {
    


    public static void sortDiagonally(int[][] mat) {
        Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        int n = mat.length;
        int m=mat[0].length;

        //Add Keys to the map
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
              
                PriorityQueue<Integer> pq = map.getOrDefault(i-j,new PriorityQueue<>());
                pq.add(mat[i][j]);
                map.put(i-j,pq);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j] = map.get(i-j).poll();
            }
        }



    }

    public static void main(String[] args) {
        
    }
}
