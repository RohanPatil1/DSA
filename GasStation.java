import java.util.ArrayList;
import java.util.List;

class PairG implements Comparable<PairG> {
    int petrol, dist;

    public PairG(int petrol, int dist) {
        this.petrol = petrol;
        this.dist = dist;
    }

    @Override
    public int compareTo(PairG o) {
        return this.dist - o.dist;
    }
}


public class GasStation {


    //O(n^2)
    public static int gasStationBruteF(int[] petrol, int[] distance) {

        List<PairG> dataList = new ArrayList<>();
        int n = petrol.length;
        //Add elements
        for (int i = 0; i < petrol.length; i++) {
            dataList.add(new PairG(petrol[i], distance[i]));
        }
        int j = 0;
        //For every element i
        for (int i = 0; i < n; i++) {
            int currPetrol = dataList.get(i).petrol;
            j = 0;
            for (j = i; j < n + i; j++) {
                if (currPetrol >= dataList.get(j).dist) {
                    currPetrol += dataList.get(j + 1).petrol - dataList.get(j).dist;
                } else {
                    break;
                }
            }

            //Check distance covered
            if (j == n + i) {
                return i;
            }

            i = j + 1;
        }

        return -1;
    }

    public static int tour(int petrol[], int distance[]) {
        // Your code here
        int n = petrol.length;

        int sumP = 0;
        int sumD = 0;

        for (int i = 0; i < n; i++) {
            sumP += petrol[i];
            sumD += distance[i];

        }

        if (sumD > sumP)
            return -1;


        int start = 0, reqFuel = 0, extraFuel = 0;

        for (int i = 0; i < n; i++) {
            extraFuel += petrol[i] - distance[i];
            if (extraFuel < 0) {
                start = i + 1;
                reqFuel += extraFuel;
                extraFuel = 0;
            }


        }

        if ((reqFuel + extraFuel) >= 0) {
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
