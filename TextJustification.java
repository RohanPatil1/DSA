import java.util.ArrayList;
import java.util.List;

public class TextJustification {


    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> ansList = new ArrayList<>();
        int wordCount = words.length;

        int start = 0;
        while (start < wordCount) {
            int end = start - 1;
            int charsAdded = 0;

            int currCharSum = charsAdded + words[end + 1].length() + (end - start + 1);
            while (end + 1 < words.length && currCharSum < maxWidth) {
                end++;
                charsAdded += words[end].length();
            }
            ansList.add(lineWithSpace(words, start, end, charsAdded, maxWidth));
            start = end + 1;

        }
        return ansList;
    }


    public String lineWithSpace(String words[], int start, int end, int lineLen, int maxWidth) {
        StringBuilder a = new StringBuilder();
        int p = 1, q = 0;
        if (end != start) {
            p = (maxWidth - lineLen) / (end - start);
            q = (maxWidth - lineLen) % (end - start);
        }

        for (int i = start; i <= end; i++) {
            a.append(words[i]);
            if (i != end) {
                if (end == words.length - 1) a.append(" ");
                else {
                    for (int j = 1; j <= p; j++) a.append(" ");
                    // extra spaces
                    if (q-- >= 1) a.append(" ");
                }
            }
        }
        // spaces in the last line
        while (a.length() < maxWidth) a.append(" ");
        return a.toString();
    }
}
