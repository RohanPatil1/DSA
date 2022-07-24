import java.util.*;

public class LongestRepSubseq {


    //BruteForce
    public static int lrsUsingMap(String A) {
        int ans = 0;
        int n = A.length();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String temp = "" + A.charAt(i) + A.charAt(j);

                if (map.containsKey(temp)) {
                    int ni = map.get(temp).get(0);
                    int nj = map.get(temp).get(1);
                    if (i != ni && j != nj) {
                        ans++;
                    }

                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    map.put(temp, list);
                }
            }
        }

        return ans;
    }


    //A2
    public static int lrs(String s) {

        String x = s;
        String y = s;
        int n = x.length();
        int m = y.length();

        String ans = "";

        // READY THE MATRIX
        int[][] t = new int[n + 1][m + 1];

        // Init
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        // Fill the rest with ans
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1) && i != j) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }

            }
        }

        return t[n][n];
    }

    public static void main(String[] args) {
        System.out.println(lrs("axxxy"));
        System.out.println(lrsUsingMap("axxxy"));
    }
}
