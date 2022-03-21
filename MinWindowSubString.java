
import java.util.*;

public class MinWindowSubString {

    public static int minWindowSubstring(String s, String ptn) {

        int result = Integer.MAX_VALUE;
        String resultStr = "";
        Map<Character, Integer> map = new HashMap<>();

        // Add ptn to map with count
        for (int m = 0; m < ptn.length(); m++) {
            char currChar = ptn.charAt(m);
            if (map.containsKey(currChar)) {
                map.put(currChar, map.get(currChar) + 1);
            } else {
                map.put(currChar, 1);
            }
        }

        int i = 0, j = 0, size = s.length();
        int count = map.size();
        while (j < size) {

            // j calculations
            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if (map.get(s.charAt(j)) == 0) {
                    count--;
                }
            }

            if (count > 0) {
                j++;
            } else if (count == 0) {

                // Get Ans
                if (j - i + 1 < result) {
                    resultStr = s.substring(i, j + 1);
                    result = j - i + 1;
                }

                // Check i calc
                while (count == 0 && i <= j) {
                    char u = s.charAt(i);
                    if (map.containsKey(u)) {
                        if (map.get(u) == 0) {
                            count++;
                        }
                        map.put(u, map.get(u) + 1);
                    }
                    i++;
                    if (count == 0 && result > (j - i + 1)) {
                        resultStr = s.substring(i, j + 1);
                        result = j - i + 1;
                    }
                }
                j++;
            }
        }

        System.out.println(resultStr);
        return result;
    }

    public static int countAnagram2(String s, String ptn) {
        int result = 0;

        int k = ptn.length();

        // {f:1,o:1,r:1}
        Map<Character, Integer> map = new HashMap<>(k);
        for (int m = 0; m < k; m++) {
            map.put(ptn.charAt(m), map.getOrDefault(ptn.charAt(m), 0) + 1);
        }

        int count = map.size();
        int i = 0, j = 0;

        while (j < s.length()) {

            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if (map.get(s.charAt(j)) == 0) {
                    count--;
                }
            }

            // String currStr = s.substring(i, j + 1);

            if ((j - i + 1) < k) {
                j++;
            } else if ((j - i + 1) == k) {
                if (count == 0) {
                    // Got ans
                    result += 1;
                }
                // Remove calculations for i
                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);

                    if (map.get(s.charAt(i)) == 1) {
                        count++;
                    }
                }

                i++;
                j++;

            }

        }

        return result;
    }

    public static void main(String[] args) {

        // System.out.println(countAnagram2("forfxxorf", "for"));

        System.out.println(minWindowSubstring("timetopractice", "toc"));

    }
}
