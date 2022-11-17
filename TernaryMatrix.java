import java.util.ArrayList;
import java.util.List;

public class TernaryMatrix {


    public static void ternaryMatrix(int n, int m) {

        int c = 0;

        List<List<Integer>> ansMatrix = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ansMatrix.add(new ArrayList<>());
        }

        for (int i = 0; i < n / 2; i++) {

            if (i % 2 == 1) c = 1;

            for (int j = 0; j < m / 2; j++) {

                if (c == 0) {

                    ansMatrix.get(2 * i).add(1);
                    ansMatrix.get(2 * i).add(0);
                    ansMatrix.get(2 * i + 1).add(0);
                    ansMatrix.get(2 * i + 1).add(1);
                    c = 1;
                } else {

                    ansMatrix.get(2 * i).add(0);
                    ansMatrix.get(2 * i).add(1);
                    ansMatrix.get(2 * i + 1).add(1);
                    ansMatrix.get(2 * i + 1).add(0);
                    c = 0;
                }
            }
        }

        System.out.println(ansMatrix);
    }

    public static void main(String[] args) {
        ternaryMatrix(4, 4);
    }
}
