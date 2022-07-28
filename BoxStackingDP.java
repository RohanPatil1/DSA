import java.util.Arrays;
import java.util.Comparator;

public class BoxStackingDP {


    static class Box {
        int l, b, h;

        public Box(int l, int b, int h) {
            this.l = l;
            this.b = b;
            this.h = h;
        }
    }

    static class BoxComparator implements Comparator<Box> {
        @Override
        public int compare(Box o1, Box o2) {
            //Sort Descending
            return o2.l * o2.b - o1.l * o1.b;
        }
    }


    public static int maxHeight(int[] ht, int[] w, int[] lt, int n) {

        Box[] boxes = new Box[6 * n];
        for (int i = 0; i < n; i++) {
            boxes[i] = new Box(ht[i], w[i], lt[i]);
            boxes[i + n] = new Box(ht[i], lt[i], w[i]);
            boxes[i + 2 * n] = new Box(lt[i], ht[i], w[i]);
            boxes[i + 3 * n] = new Box(lt[i], w[i], ht[i]);
            boxes[i + 4 * n] = new Box(w[i], lt[i], ht[i]);
            boxes[i + 5 * n] = new Box(w[i], ht[i], lt[i]);
        }

        Arrays.sort(boxes, new BoxComparator());
        for (int i = 0; i < boxes.length; i++) {
            System.out.println("("+boxes[i].l+","+boxes[i].b+","+boxes[i].h+")");
        }

        int[] t = new int[6 * n];
        int maxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < 6 * n; i++) {
            //t[i] will tell us what is the maxHeight after including i
            int tempMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (boxes[j].l > boxes[i].l && boxes[j].b > boxes[i].b) {
                    tempMax = Math.max(tempMax, t[j]);
                }
            }
            t[i] = tempMax + boxes[i].h;
            maxHeight = Math.max(maxHeight, t[i]);
        }

        return maxHeight;
    }


    public static void main(String[] args) {
        System.out.println(maxHeight(
                new int[]{4, 1, 4, 10},
                new int[]{6, 2, 5, 12},
                new int[]{7, 3, 6, 32},
                4
        ));
    }

}
