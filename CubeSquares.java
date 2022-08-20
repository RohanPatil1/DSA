import java.util.HashMap;
import java.util.Map;

public class CubeSquares {

    //Return count of squares & cubes from 1 to N
    public static int cubeSquares(int N) {
        if (N == 1) return 1;

        int count = 0;

        count = (int) Math.sqrt(N) + (int) Math.cbrt(N)
                - (int) (Math.sqrt(Math.cbrt(N)));
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(cubeSquares(3, new int[]{10, 2, 5}));


    }

}
