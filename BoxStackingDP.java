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

    public static void printBoxes(Box[] arr) {
        for (Box b : arr) {
            System.out.println("Box(" + b.l + "," + b.b + "," + b.h + ")");
        }
        System.out.println("");
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
        printBoxes(boxes);

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

    //-------------A2-----------------Time=O(n^2) Space=O(n)
    public int maxHeight(int[][] cuboids) {
        int maxHeight = 0;
//[[50,45,20],[95,37,53],[45,23,12]]
        //Sort the dimensions
        for (int[] dim : cuboids) {
            Arrays.sort(dim);
        }

        //Sort Boxes according l*b
        Arrays.sort(cuboids, new Comparator<int[]>() {
            @Override
            public int compare(int[] d1, int[] d2) {
                if(d1[0] != d2[0]) return d2[0] - d1[0];
                else if(d1[1] != d2[1]) return d2[1] - d1[1];
                else return d2[2] -d1[2];

            }
        });
        /* After sorting
            37 53 95
            20 45 50
            12 23 45

         */
        int n = cuboids.length;
        int[] dp = new int[n];

        //Check if we can put cuboid[j] on cuboid[i] if yes then add its height
        for (int j = 0; j < n; j++) {
            dp[j] = cuboids[j][2];
            for (int i = 0; i < j; i++) {
                if (cuboids[i][0] >= cuboids[j][0] &&
                        cuboids[i][1] >= cuboids[j][1] &&
                        cuboids[i][2] >= cuboids[j][2]
                ) {
                    dp[j] = Math.max(dp[j], dp[i] + cuboids[j][2]);
                }
            }
            maxHeight = Math.max(maxHeight, dp[j]);
        }

        return maxHeight;
    }

    public static void main(String[] args) {
//        System.out.println(maxHeight(
//                new int[]{4, 1, 4, 10},
//                new int[]{6, 2, 5, 12},
//                new int[]{7, 3, 6, 32},
//                4
//        ));
        System.out.println(maxHeight(
                new int[]{1},
                new int[]{2},
                new int[]{3},
                1
        ));

    }

}
