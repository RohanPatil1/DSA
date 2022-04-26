import java.util.*;

public class ScrambledStrings {

    static Map<String, Boolean> map = new HashMap<>();

    public static boolean scramStr(String a, String b) {

        String key = a + " " + b;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (a.indexOf(b) == 0) {
            return true;
        }
        if (a.length() <= 1) {
            return false;
        }
        if (a.length() != b.length()) {
            return false;
        }

        int n = a.length();
        boolean flag = false;
        for (int i = 1; i <= n - 1; i++) {
            boolean cond1 = scramStr(a.substring(0, i), b.substring(b.length() - i))
                    && scramStr(a.substring(i), b.substring(0, b.length() - i));
            boolean cond2 = scramStr(a.substring(0, i), b.substring(0, i)) && scramStr(a.substring(i), b.substring(i));

            if (cond1 || cond2) {
                flag = true;
                map.put(key, flag);
                break;
            }
        }

        return flag;
    }

    public static void main(String[] args) {

        System.out.println(scramStr("phqtrnilf", "ilthnqrpf"));
    }
}
