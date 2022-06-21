import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseWorkInString {
    public static String reverseWords(String S) {
        // code here
        S += ".";
        List<String> list = new ArrayList<String>();

        int start = 0;
        for (int i = 0; i < S.length(); i++) {

            char curr = S.charAt(i);

            if (curr == '.') {
                String word = S.substring(start, i);
                list.add(word);
                start = i + 1;

            }

        }


        Collections.reverse(list);
        String res = "";
        StringBuilder sb = new StringBuilder(res);
        for (String s : list) {
            sb.append(s + ".");
        }

        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("i.like.this.program.very.much"));
    }

}
