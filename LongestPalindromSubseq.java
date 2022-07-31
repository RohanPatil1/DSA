import java.util.*;

public class LongestPalindromSubseq {

    // Take a reverse of s, find lcs of s,s2
    public static int getLPS(String s) {
        // Get reverse string
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String s2 = sb.toString();

        int n = s.length();
        int m = n;

        int[][] t = new int[n + 1][m + 1];

        // Init
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (n == 0 || m == 0) {
                    t[i][j] = 0;
                }
            }
        }

        // Fill thre rest with ans
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == s2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        return t[n][m];
    }

    public static <T> T[] reverse(T[] array) {


        T[] copy = array.clone();
        Collections.reverse(Arrays.asList(copy));
        return copy;
    }

    public static int[] reverse3(int[] nums) {
        int[] reversed = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            reversed[i] = nums[nums.length - 1 - i];
        }
        return reversed;
    }

    public static int lps(int[] arr1) {
        int n = arr1.length;
        int[] arr2 = reverse3(arr1);

        int m = n;

        int[][] t = new int[n + 1][m + 1];

        // Init
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (n == 0 || m == 0) {
                    t[i][j] = 0;
                }
            }
        }

        // Fill thre rest with ans
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        return t[n][m];
    }


    public static int miniChange(int n, int[] arr) {
        // code here
        return n - lps(arr);
    }

//    public static long maxScore(int n, int[] points) {
//        // code here
//        long ans = Long.MIN_VALUE;
//
//        for (int i = 0; i < n; i++) {
//            int score = points[i];
//            int indexToTravel = i + points[i];
//            while (indexToTravel < n) {
//                score += points[indexToTravel];
//                if (i + points[indexToTravel] > n) {
//                    break;
//                } else {
//                    indexToTravel +=  points[indexToTravel];
//                }
//            }
//            ans = Math.max(ans, score);
//        }
//
//        return ans;
//
//    }

    public static void main(String[] args) {
        System.out.println(getLPS("agbcba"));
        System.out.println(miniChange(16, new int[]{1, 2, 3, 4, 5, 5, 6, 7, 7, 6, 5, 5, 4, 1, 2, 3}));

    }
}
