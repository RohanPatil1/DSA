import java.util.*;

public class TechMahidraChallenge {

    public static int solve(int n) {

        if (n < 4) {
            return n;
        }

        int f = 1;
        int s = 2;
        int t = 3;
        int ans = 0;

        for (int i = 4; i <= n; i++) {
            ans = f + s + t;
            f = s;
            s = t;
            t = ans;
        }

        return ans % 1000000007;
    }

    public static void main(String[] args) {
        System.out.println(solve(6));
    }
}
