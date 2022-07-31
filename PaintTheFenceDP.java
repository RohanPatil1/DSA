public class PaintTheFenceDP {


    public static long paintTheF(int n, int k, long diff, long total, int i) {
        if (i == n) return total;


        long same = diff;
        diff = total * (k - 1);
        total = same + diff;
        return paintTheF(n, k, diff, total, i + 1);
    }


    public static long paintTheFence(int n, int k) {

        if (n == 1) return k;

        long same = k;
        long diff = k * (k - 1);
        long total = same + diff;
        if (n == 2) return total;
        return paintTheF(n, k, diff, total, 2);
    }


    //----------------Better itr solution------------recursive will overflow large input
    public static long paintTheFenceItr(int n, int k) {

        long same = k;
        long diff = (long) k * (k - 1);
        long total = same + diff;
        for (int i = 3; i <= n; i++) {
            same = diff;
            diff = total * (k - 1);
            total = same + diff;
        }
        return total;
    }

    public static void main(String[] args) {

        System.out.println(paintTheFence(4, 3));
        System.out.println(paintTheFenceItr(4, 3));
    }


}
