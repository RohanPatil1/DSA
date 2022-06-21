import java.util.ArrayList;
import java.util.List;

public class IntegerToRoman {


    public static String getRoman(int num) {
        //All letters roman
        String[] dict = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] index = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        String res = "";

        for (int i = 0; num != 0; i++) {

            while (num >= index[i]) {
                num -= index[i];
                res += dict[i];
            }
        }

        return res;
    }


    public static void main(String[] args) {

    }
}
