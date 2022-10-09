import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStr {

    //encodes a list of strings to a single string
    public String encode(List<String> strs) {

        StringBuilder encodedStr = new StringBuilder();
        for (String s : strs) {
            encodedStr.append(s.length()).append("₹").append(s);
        }

        return encodedStr.toString();
    }

    //decode a single string to a list of strings
    public List<String> decode(String str) {

        List<String> stringList = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            stringList.add(str.substring(j + 1, i));
        }

        return stringList;
    }



}
