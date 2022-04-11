import java.util.*;

public class TowerOfHanoi {

    public static void tohR(int s, int d, int h, int n) {
        if (n == 1) {
            System.out.println("Moving plate " + n + " from " + s + " to " + d);
            return;
        }
        tohR(s, h, d, n - 1);
        System.out.println("Moving plate " + n + " from " + s + " to " + d);
        tohR(h, d, s, n - 1);
        return;
    }

    public static void main(String[] args) {
        tohR(1, 2, 3, 3);
        System.out.println(2%3);
    }
}
