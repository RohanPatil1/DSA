public class DistinctSubseqDP {


    private static int recursion(String A, String B, int i, int j) {
        if (j == B.length()) return 1;
        if (i == A.length()) return 0;

        if (A.charAt(i) == B.charAt(j)) {
            int ans1 = recursion(A, B, i + 1, j + 1);
            int ans2 = recursion(A, B, i + 1, j);
            return ans1 + ans2;
        } else {
            return recursion(A, B, i + 1, j);
        }
    }


    public static int distinctSubseq(String A, String B) {

        return recursion(A, B, 0, 0);
    }


    public static void main(String[] args) {
        System.out.println(distinctSubseq("abbc", "abc"));
    }
}
