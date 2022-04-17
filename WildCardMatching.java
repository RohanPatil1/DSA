import java.util.*;

public class WildCardMatching {

    static int[][] t = new int[1001][1001];

    public static int wcm(String p, String s, int i, int j) {
        int ans = 0;

        // Finished Traversing both string and they ending at the same index
        if (i == -1 && j == -1) {
            return 1;
        }

        // String ended but pattern is still left
        if (j == -1) {
            // Case if the elements left in the pattern is *
            // If yes, true... NOT *, false
            for (int k = 0; k < i; k++) {
                if (p.charAt(k) != '*') {
                    return 0;
                }
            }
            // All *
            return 1;
        }

        // If pattern done but string left so we don't have anything to match
        if (i == -1) {
            return 0;
        }

        // Memoization
        if (t[i][j] != -1) {
            return t[i][j];
        }

        //If p and s match or ? then move
        if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') {
            return t[i][j] = wcm(p, s, i - 1, j - 1);
        }
        //Case *
        if(p.charAt(i)=='*'){
            int op1 = wcm(p,s,i,j-1);
            int op2 = wcm(p,s,i-1,j);
            t[i][j] = Math.max(op1,op2); //1 0 -> 1
        }

        //p(i) and s(j) didnt match
        return t[i][j] = 0;
    }

    public static void main(String[] args) {

        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        String s = "";
        String p = "";
        System.out.println(wcm(p, s, p.length() - 1, s.length() - 1));

    }
}
