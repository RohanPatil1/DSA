import java.util.HashMap;
import java.util.Map;

public class WordPatternEasy {

    public boolean wordPattern(String pattern, String s) {

        Map<Character, String> map = new HashMap<>();

        String[] words = s.split(" ");

        if(words.length != pattern.length()) return false;

        for(int i=0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                String value = map.get(c);
                if(!value.equals(words[i])){
                    return false;
                }
            }else{
                if(map.containsValue(words[i])) return false;
                map.put(c, words[i]);
            }
        }

        return true;

    }
}
