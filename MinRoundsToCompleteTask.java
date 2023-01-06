import java.util.HashMap;
import java.util.Map;

public class MinRoundsToCompleteTask {
    public int minimumRounds(int[] tasks) {

        Map<Integer, Integer> map = new HashMap<>();

        int ansCount = 0;

        ///Frequency Count
        for(int task : tasks){
            map.put(task, map.getOrDefault( task, 0) + 1 );
        }

        ///Iterate through map
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){

            int curr = entry.getValue();
            if(curr == 1) return -1;
            ansCount += (curr + 2) / 3;



        }


        return ansCount;
    }
}
