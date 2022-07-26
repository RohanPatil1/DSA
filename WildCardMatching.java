import java.util.*;

public class WildCardMatching {

    static int[][] t = new int[1001][1001];

    public static int wcm(String p, String s, int i, int j) {

        // Finished Traversing both strings and they are ending at the same index
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
        } else if (p.charAt(i) == '*') {
            //Case *
            int op1 = wcm(p, s, i, j - 1);
            int op2 = wcm(p, s, i - 1, j);
            return t[i][j] = Math.max(op1, op2); //1 0 -> 1
        } else {
            //p(i) and s(j) didnt match
            return t[i][j] = 0;
        }

    }

    //Bottom Up Approach
    public static boolean regexMatching(String p, String s) {
        int pSize = p.length(), sSize = s.length();
        boolean[][] tp = new boolean[sSize + 1][pSize + 1];

        //Init
        tp[0][0] = true;
        int k = 1;
        while (p.charAt(k - 1) == '*') {
            tp[0][k] = true;
        }

        //Fill the rest with ans
        for (int i = 1; i < sSize + 1; i++) {
            for (int j = 1; j < pSize + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    tp[i][j] = tp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    tp[i][j] = tp[i - 1][j] || tp[i][j - 1];
                } else {
                    tp[i][j] = false;
                }
            }
        }

        return tp[sSize][pSize];
    }


    public static void main(String[] args) {

        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        String s = "abc";
        String p = "a*?";
        System.out.println(wcm(p, s, p.length() - 1, s.length() - 1));
        System.out.println(regexMatching(p, s));

    }
}
