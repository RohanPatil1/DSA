import java.util.Arrays;

public class DecodeWays12 {


    ///Recursion + Memoization
    int[] t = new int[101];

    public int numDecodings(String s) {

        if (s.charAt(0) == '0') {
            return 0;
        }
        Arrays.fill(t, -1);
        return solve(s, s.length());
    }


    public int solve(String s, int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (t[n] != -1) {
            return t[n];
        }

        int count = 0;
        if (s.charAt(n - 1) != '0') {
            count = solve(s, n - 1);
        }

        boolean isLessThan26 = ((s.charAt(n - 2) - '0') * 10 + (s.charAt(n - 1) - '0')) <= 26;
        if (s.charAt(n - 2) != '0' && isLessThan26) {
            count += solve(s, n - 2);
        }

        return t[n] = count;
    }


    //Bottom up solution
    public int numDecodingsBUP(String s) {
        int len = s.length();
        int temp2 = 1, temp1 = (s.charAt(len - 1) != '0') ? 1 : 0;

        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                temp2 = temp1;
                temp1 = 0;
                continue;
            }
            int count1 = temp1;
            int count2 = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26 ? temp2 : 0;
            temp2 = temp1;
            temp1 = count1 + count2;
        }

        return temp1;
    }


    //------------DECODE2
    public static int numsOfCoding2(String s) {
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = decodeSingleChar(s.charAt(0));

        for (int i = 2; i <= s.length(); i++) {
            char prevChar = s.charAt(i - 2);
            char currChar = s.charAt(i - 1);

            //Single char
            dp[i] += dp[i - 1] * decodeSingleChar(currChar);

            //Double char
            dp[i] += dp[i - 2] * decodeTwoChar(prevChar, currChar);

        }

        return (int) dp[s.length()];
    }

    public static int decodeSingleChar(char c) {
        if (c == '*') {
            return 9;
        } else if (c == '0') {
            return 0;
        }
        return 1;
    }

    public static int decodeTwoChar(char first, char second) {
        switch (first) {
            case '*':
                if (second == '*') {
                    return 15;
                } else if (second >= '0' && second <= '6') {
                    return 2;
                } else {
                    return 1;
                }

            case '1':
                if (second == '*') {
                    return 9;
                } else {
                    return 1;
                }

            case '2':
                if (second == '*') {
                    return 6;
                } else if (second >= '0' && second <= '6') {
                    return 1;
                } else {
                    return 0;
                }

            default:
                return 0;
        }
    }
}
