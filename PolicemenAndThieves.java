import java.util.ArrayList;

public class PolicemenAndThieves {

    public static int catchMaxThieves(char[] arr, int k) {

        int n = arr.length;
        ArrayList<Integer> police = new ArrayList<>();
        ArrayList<Integer> thief = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            if (c == 'P') {
                police.add(i);
            } else {
                thief.add(i);
            }
        }

        int p = 0, t = 0;
        int count = 0;
        while (p < police.size() && t < thief.size()) {
            if (Math.abs(police.get(p) - thief.get(t)) <= k) {
                count++;
                p++;
                t++;
            } else if (police.get(p) > thief.get(t)) {
                t++;
            } else {
                p++;
            }
        }
        return count;


    }


    public static void main(String[] args) {

    }

}
