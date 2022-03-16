import java.util.HashSet;

//LONGEST SUBSTRING WITHOUT REPEATING CHARACTER
public class LongestSubstringWithoutRepeatingCharacter {

    public static int longestSubStr(String s) {
        int max = 0;
        int i = 0;
        int j = 0;

        HashSet<Character> hashSet = new HashSet();
        // abcabcbb
        while (j < s.length()) {
            if (!hashSet.contains(s.charAt(j))) {
                hashSet.add(s.charAt(j));
                j++;
                max = Math.max(hashSet.size(), max);
            } else {
                hashSet.remove(s.charAt(i));
                i++;
            }
        }

        System.out.println(hashSet);
        return max;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        int result = longestSubStr(s);
        System.out.println(result);
    }

}
