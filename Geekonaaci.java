
import java.util.*;
import java.lang.*;
import java.io.*;

class Geekonaaci {

    static int geekonacci(int n, int a, int b, int c, int k) {
        if (n == k) {
            return c;
        }

        int ans = a + b + c;
        a = b;
        b = c;
        c = ans;

        return geekonacci(n, a, b, c, k + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int n = sc.nextInt();
            int k = 3;
            int ans = geekonacci(n, a, b, c, k);
            System.out.println(ans);
        }
    }
}


