import java.util.LinkedList;
import java.util.Queue;

public class RemoveFirstK {
    public static String removeFirst(String A) {
        String ans = "";
        Queue<Character> queue = new LinkedList<>();
        int[] flag = new int[26];


        for (int i = 0; i < A.length(); i++) {
            char curr = A.charAt(i);
            flag[curr - 'a']++;

            if (flag[curr - 'a'] == 1)
                queue.add(curr);

            while (!queue.isEmpty() && flag[queue.peek() - 'a'] > 1) {
                queue.poll();
            }
            if (queue.isEmpty()) {
                ans += "#";
            } else {
                ans += queue.peek(); //First non repeating char
            }
        }
        return ans;
    }

    public static void main(String[] args) {
                System.out.println(removeFirst("aabc"));
    }
}
