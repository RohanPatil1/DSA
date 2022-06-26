import java.util.ArrayList;
import java.util.Arrays;

class Pair implements Comparable<Pair> {
    int petrol, dist;

    public Pair(int petrol, int dist) {
        this.petrol = petrol;
        this.dist = dist;
    }

    @Override
    public int compareTo(Pair o) {
        return this.dist - o.dist;
    }
}


public class GasStation {

    public static int tour(int petrol[], int distance[]) {
        // Your code here
        int n = petrol.length;

        int sumP = 0;
        int sumD  =0;

        for (int i = 0; i < n; i++) {
            sumP += petrol[i];
            sumD += distance[i];

        }

        if(sumD>sumP)
            return -1;


        int start = 0,reqFuel=0,extraFuel=0;

        for(int i=0;i<n;i++){
            extraFuel += petrol[i] - distance[i];
            if(extraFuel<0){
                start = i+1;
                reqFuel += extraFuel;
                extraFuel = 0;
            }


        }

        if((reqFuel+extraFuel)>=0){
            return start;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] petrol = new int[]{4, 6, 7, 4};
        int[] dist = new int[]{6, 5, 3, 5};

        System.out.println(tour(petrol, dist));
    }


}
