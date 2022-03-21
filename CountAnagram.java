import java.util.*;

public class CountAnagram {

    public static Boolean isAnagram(String str1, String str2) {

        // convert strings to char array
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        // sort the char array
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // if sorted char arrays are same
        // then the string is anagram
        boolean result = Arrays.equals(charArray1, charArray2);

        return result;
    }

    // TLE Error
    public static int countAnagram(String s, String ptn) {
        int result = 0;
        int i = 0, j = 0;
        int k = ptn.length();

        while (j < s.length()) {

            String currStr = s.substring(i, j + 1);

            if ((j - i + 1) < k) {
                j++;
            } else if ((j - i + 1) == k) {
                if (isAnagram(currStr, ptn)) {
                    result += 1;
                }
                j++;
                i++;
            }

        }

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

        System.out.println(countAnagram("forfxxorf", "for"));

    }
}
