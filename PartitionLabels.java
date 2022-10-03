import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public List<Integer> partitionLabels(String str) {

        List<Integer> partition = new ArrayList<>();
        char[] s = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        //Frequency map
        for(int i=0;i<s.length;i++){
            map.put(s[i], i);
        }


        int size = 0;
        int end = 0;
        int sumFactor = 0;

        for(int i=0;i<s.length;i++){

            end = Math.max(end, map.get(s[i]));
            size++;

            if(size+sumFactor >end){
                partition.add(size);
                sumFactor += size;
                size = 0;

                end = 0;
            }

        }

        return partition;
    }
}
