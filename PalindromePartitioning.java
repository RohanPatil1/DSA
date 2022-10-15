import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {


    public List<List<String>> partition(String s) {

        List<List<String>> resultList = new ArrayList<>();

        List<String> currList = new ArrayList<>();


        solve(0, s, currList, resultList);
        return resultList;
    }

    private void solve(int index, String str, List<String> currList, List<List<String>> resultList) {
        if (index == str.length()) {
            resultList.add(new ArrayList<>(currList));
            return;
        }

        for (int i = index; i < str.length(); i++) {
            if (isPalindrome(str, index, i)) {
                currList.add(str.substring(index, i + 1));
                solve(i + 1, str, currList, resultList);
                currList.remove(currList.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }

        return true;
    }

}
