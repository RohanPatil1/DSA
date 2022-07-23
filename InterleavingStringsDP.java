public class InterleavingStringsDP {

    public static boolean recursion(String A, String B, String C, int i, int j, int k) {

        if (k == C.length() && i == A.length() && j == B.length()) return true;
        if (k == C.length()) return false;
        if (i == A.length()) {
            if (C.charAt(k) == B.charAt(j)) {
                return recursion(A, B, C, i, j + 1, k + 1);
            } else {
                return false;
            }
        }

        if (j == B.length()) {
            if (C.charAt(k) == A.charAt(i)) {
                return recursion(A, B, C, i + 1, j, k + 1);
            } else {
                return false;
            }
        }

        if (C.charAt(k) == A.charAt(i) && C.charAt(k) == B.charAt(j)) {
            boolean ans1 = recursion(A, B, C, i + 1, j, k + 1);
            boolean ans2 = recursion(A, B, C, i, j + 1, k + 1);
            return ans1 || ans2;
        } else if (C.charAt(k) == A.charAt(i)) {
            return recursion(A, B, C, i + 1, j, k + 1);
        } else if (C.charAt(k) == B.charAt(j)) {
            return recursion(A, B, C, i, j + 1, k + 1);
        } else {
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
