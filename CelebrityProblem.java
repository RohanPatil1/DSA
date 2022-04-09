import java.util.*;

public class CelebrityProblem {

    // O(n2)
    public static int getCelebN2(int[][] arr, int n) {
        int result = -1;

        int[] inArr = new int[n];
        int[] outArr = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    inArr[j]++;
                    outArr[i]++;
                }
            }
        }
        // Get Ans
        for (int i = 0; i < n; i++) {
            if (inArr[i] == n - 1 && outArr[i] == 0) {
                return i;
            }
        }

        return result;
    }

    // O(n)
    public static int getCelebN(int[][] arr, int n) {
        int result = -1;

        Stack<Integer> s = new Stack<>();

        // Push all the potential celbs
        for (int i = 0; i < n; i++) {
            s.push(i);
        }

        while (s.size() >= 2) {
            int i = s.pop();
            int j = s.pop();

            // Check for i j
            if (arr[i][j] == 1) {
                s.push(j);
            } else {
                s.push(i);
            }
        } // While end

        // Last man standing
        int lms = s.pop();

        // Check if lms is celeb
        for (int i = 0; i < n; i++) {
            if (i != lms) {
                if (arr[i][lms] == 0 || arr[lms][i] == 1) {
                    return -1;
                }
            }
        }
        result = lms;
        return result;
    }
}
