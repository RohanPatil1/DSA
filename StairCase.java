import java.util.Arrays;

public class StairCase {


    static int[] t = new int[10001];

    static int countStair(int n) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return 1;
//        if (n == 2) return 2;

        if (t[n] != -1) return t[n];

        int count = countStair(n - 1);
        count += countStair(n - 2);

        return t[n] = count % 1000000007;
    }

    public static void main(String[] args) {
        Arrays.fill(t, -1);
        System.out.println(countStair(84));
    }
}
