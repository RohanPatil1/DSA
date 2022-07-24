import java.util.HashMap;
import java.util.Map;

public class InterleavingStringsDP {

    static Map<String, Boolean> t = new HashMap<>();

    public static boolean recursion(String A, String B, String C, int i, int j, int k) {


        if (k == C.length() && i == A.length() && j == B.length()) return true;
        if (k == C.length()) return false;
        if (t.containsKey("" + i + j + k)) return t.get("" + i + j + k);

        if (i == A.length()) {
            if (C.charAt(k) == B.charAt(j)) {
                boolean ans = recursion(A, B, C, i, j + 1, k + 1);
                t.put("" + i + j + k, ans);
                return ans;
            } else {
                return false;
            }
        }

        if (j == B.length()) {
            if (C.charAt(k) == A.charAt(i)) {
                boolean ans = recursion(A, B, C, i + 1, j, k + 1);
                t.put("" + i + j + k, ans);
                return ans;
            } else {
                t.put("" + i + j + k, false);
                return false;
            }
        }

        if (C.charAt(k) == A.charAt(i) && C.charAt(k) == B.charAt(j)) {
            boolean ans1 = recursion(A, B, C, i + 1, j, k + 1);
            boolean ans2 = recursion(A, B, C, i, j + 1, k + 1);
            t.put("" + i + j + k, ans1 || ans2);
            return ans1 || ans2;
        } else if (C.charAt(k) == A.charAt(i)) {
            boolean ans  = recursion(A, B, C, i + 1, j, k + 1);
            t.put("" + i + j + k, ans);
            return ans;
        } else if (C.charAt(k) == B.charAt(j)) {
            boolean ans = recursion(A, B, C, i, j + 1, k + 1);
            t.put("" + i + j + k, ans);
            return ans;
        } else {
            t.put("" + i + j + k, false);
            return false;
        }
    }


    public static int isInterleave(String A, String B, String C) {

        boolean result = recursion(A, B, C, 0, 0, 0);
        return (result) ? 1 : 0;

    }

    public static void main(String[] args) {
        String A = "aabcc";
        String B = "dbbca";
        String C = "aadbbcbcac";
        System.out.println(isInterleave(A, B, C));
    }
}
