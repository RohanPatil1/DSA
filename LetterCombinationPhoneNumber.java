import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationPhoneNumber {

    //TimeComplexity = O(3^n) or if length of maxString from digit is k then its O(k^n) for eg "pqrs" so 4^n
    public static List<String> getPhoneCombination(String digits) {
        List<String> resultList = new ArrayList<>();

        HashMap<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        Deque<String> dq = new LinkedList<>();
        //Start with empty and then add every iteration digit
        dq.add("");//(i)={ [] } (ii)={ [a],[b],[c] } (iii)={ [ad],[ae],[af], [bd], [be]... }

        for (int i = 0; i < digits.length(); i++) { //234

            String d = digits.substring(i, i + 1); //2 then 3 then 4
            String lettersOfD = map.get(d); //abc

            int n = dq.size();
            for (int j = 0; j < n; j++) {
                String pull = dq.pollFirst(); //[] then {[a],[b],[c]}

                //get letters from digits to add with current dq
                for (int k = 0; k < lettersOfD.length(); k++) {
                    char currChar = lettersOfD.charAt(k);  // a... b...c
                    String newString = pull.concat(currChar + ""); //[]+a ... []+b ... []+c
                    dq.add(newString);
                }
            }

        }

        //Add to resultList
        while (!dq.isEmpty()) {
            resultList.add(dq.poll());
        }


        return resultList;
    }

}
