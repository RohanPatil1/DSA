import java.util.*;

public class EggDroppingProblem {

    static Map<String, Integer> map = new HashMap<>();

    public static int eggdp(int e, int f) {

        if (f == 1 || f == 0)
            return f;
        if (e == 0 || e == 1)
            return f;
        String key = e + " " + f;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int min = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {

            int temp = 1 + Math.max(eggdp(e - 1, k - 1), eggdp(e, f - k));
            min = Math.min(min, temp);

        }

        map.put(key, min);
        return min;
    }

    public static void main(String[] args) {
        System.out.println(eggdp(3, 5));
    }
}
