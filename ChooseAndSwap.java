import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChooseAndSwap {

    static String replace(String str, char a, char b) {

        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a)
                ans += b + "";
            else if (str.charAt(i) == b)
                ans += a + "";
            else
                ans += str.charAt(i);
        }
        return ans;

    }

    public static String chooseSwap(String str) {


        List<Character> list = new ArrayList<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (!list.contains(c)) {
                list.add(c);
            }
        }
        Collections.sort(list);

        for (int i = 0; i < n; i++) {
//            char curr = str.charAt(i);


            list.remove(i);
            if (list.isEmpty()) break;

            char curr = list.get(0); //smallest char
            if (curr < str.charAt(i)) {
                //Replace
                replace(str, str.charAt(i), curr);
                break;

            }


        }

        return str;
    }

    public static void main(String[] args) {

    }
}
