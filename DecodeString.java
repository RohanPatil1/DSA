import java.util.Queue;
import java.util.LinkedList;

public class DecodeString {

    int i = 0;

    public String decodeString(String s) {

        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            q.add(s.charAt(i));
        }


        return solve(q);
    }


    public String solve(Queue<Character> q) {

        StringBuilder sb = new StringBuilder();

        int num = 0;

        while (!q.isEmpty()) {

            char currChar = q.poll();
            //3 ] [ a

            if (Character.isDigit(currChar)) {
                num = num * 10 + (currChar - '0'); //54 => 50 + 4
            } else if (currChar == ']') {
                break;
            } else if (currChar == '[') {

                String subP = solve(q);
                //3 acc
                for (int i = 0; i < num; i++) {
                    sb.append(subP);
                }
                num = 0;
            } else {
                sb.append(currChar);
            }

        }


        return sb.toString();
    }

    public String solve2(String s) {

        StringBuilder sb = new StringBuilder();

        int num = 0;

        //i is globally static
        while(i<s.length()){
            char currChar = s.charAt(i++);
            //3 ] [ a

            if (Character.isDigit(currChar)) {
                num = num * 10 + (currChar - '0'); //54 => 50 + 4
            } else if (currChar == ']') {
                break;
            } else if (currChar == '[') {

                String subP = solve2(s);
                //3 acc
                for (int k = 0; k < num; k++) {
                    sb.append(subP);
                }
                num = 0;
            } else {
                sb.append(currChar);
            }
        }



        return sb.toString();
    }
}
