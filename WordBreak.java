import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {


    public static boolean wordBreak(String str, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        return solve(str, wordList, set);
    }

    private static boolean solve(String str, List<String> wordList, Set<String> set) {
        int size = str.length();

        if (size == 0) return true; //s=race ["race"]

        for (int i = 1; i <= size; i++) {
            String subStr = str.substring(0, i); //i is exclusive
            if (set.contains(subStr) && solve(str.substring(i, size), wordList, set)) {
                return true;
            }
        }

        return false;
    }
}
