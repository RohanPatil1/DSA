import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){

            char[] freq = new char[26];
            for(int i=0; i<str.length(); i++){
                freq[str.charAt(i) - 'a']++;
            }

            String freqStr = new String(freq);
            List<String> currList = map.getOrDefault(freqStr, new ArrayList<>());
            currList.add(str);

            map.put(freqStr, currList);
        }




        return new ArrayList<>(map.values());
    }
}
