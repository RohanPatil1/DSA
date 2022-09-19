import java.util.Arrays;

public class MaximumMatchingPlayersTrainers {


    public int matchPlayersAndTrainers(int[] players, int[] trainersArr) {

        Arrays.sort(players);

//        int[] arrDesc = Arrays.stream(trainersArr).boxed()
//                .sorted(Collections.reverseOrder())
//                .mapToInt(Integer::intValue)
//                .toArray();
        int n=players.length;
        int m=trainersArr.length;
        Integer[] trainers = new Integer[m]; // so we can use Arrays.sort(trainers,Collections.reverseOrder());
        for (int i = 0; i < m; i++) {
            trainers[i] = trainersArr[i];
        }
        Arrays.sort(trainers);
        int i=0;
        int j=0;

        int count =0;

        while(i<n && j<m){

            if(players[i]<=trainers[j]){
                count++;
                i++;
                j++;
            }else if(players[i] > trainers[j]){
                j++;
            }

        }

        return count;
    }
}
