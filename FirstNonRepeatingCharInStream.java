import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharInStream {

    public String firstNonRepeating(String str) {

        Queue<Character> q = new LinkedList<>();
        int[] flag = new int[26];
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            flag[curr - 'a']++;
            if (flag[curr - 'a'] == 1) {
                q.add(curr);
            }

            while (!q.isEmpty() && flag[q.peek()] - 'a' > 1) {
                q.poll();
            }

            if (q.isEmpty()) ans += "#";
            else ans += q.peek();

        }

        return ans;
    }

}
