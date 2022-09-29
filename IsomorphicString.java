import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    public static boolean isomorphicStr(String s, String t) {

        //Case 1 of failure is s[i] is mapped with t[i] & t[i+x]
        //Case 2 of failure is t[i] is already mapped and we are using it to map another s[i]


        if (s.length() != t.length()) {
            return false;
        }

        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();

        Map<Character, Character> cMap = new HashMap<>();
        Map<Character, Boolean> usedMap = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {
            char si = s1[i];
            char ti = s2[i];

            if (cMap.containsKey(si)) {
                if (cMap.get(si) != ti) return false;
            } else {
                //not mapped
                if (usedMap.containsKey(ti)) {
                    return false;
                } else {
                    cMap.put(si, ti);
                    usedMap.put(ti, true);
                }
            }
        }
        return true;

    }
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }



        Map<Character, Character> cMap = new HashMap<>();
        Map<Character, Boolean> usedMap = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {
            char si = s.charAt(i);
            char ti = t.charAt(i);

            if (cMap.containsKey(si)) {
                if (cMap.get(si) != ti) return false;
            } else {
                //si is not mapped

                //Now if we are mapping si-ti, we need to make sure ti is not mapped

                //Check if ti is already used or not
                if (usedMap.containsKey(ti)) {
                    return false;
                }else {
                    cMap.put(si, ti);
                    usedMap.put(ti, true);
                }
            }
        }
        return true;
    }
}
