import java.util.*;

public class LongestSubstringWithKUniqueCharacters {

    public static int getLongSubStrLen(String s, int k) {
        int result = 0;

        int i = 0, j = 0;
        int size = s.length();

        Map<Character, Integer> map = new HashMap<>();

        while (j < size) {

            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
            } else {
                map.put(s.charAt(j), 1);
            }

            if (map.size() < k) {
                j++;
            } else if (map.size() == k) {
                result = Math.max(result, j - i + 1);
                j++;
            } else if (map.size() > k) {
                // map.size() > k
                while (map.size() > k) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0) {
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }

        }

        return result;

    }

    // Problem Version 2
    // Longest Substring with no Repeating Character
    public static int getLongSubStrNoRep(String s) {
        int result = 0;

        int i = 0, j = 0;
        int size = s.length();

        Map<Character, Integer> map = new HashMap<>();

        while (j < size) {

            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
            } else {
                map.put(s.charAt(j), 1);
            }
        
            if (map.size() == (j - i + 1)) {
                result = Math.max(result, j - i + 1);
                j++;
            } else if (map.size() < (j - i + 1)) {
                // map.size() > k
                while (map.size() < (j - i + 1)) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0) {
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }

        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(getLongSubStrLen("aabacbebebe", 3));
        System.out.println(getLongSubStrNoRep("fasdfawefuwehjfajdsbvbvbbbcbbbbbbbbcbksfhskjdhaflkhjasdlkfha"));
        // System.out.println(getLongSubStrNoRep("aab"));

    }
}
