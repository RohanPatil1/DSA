public class LongestPalindromSubstring {


    public static String lpsubstringDP(String str) {

        int maxLen = 0;
        String ansStr = "";
        int n = str.length();
        int[][] dp = new int[n][n];
        for (int diff = 0; diff < n; diff++) {

            for (int i = 0, j = i + diff; j < n; i++, j++) {

                if (i == j) {
                    dp[i][j] = 1;
                } else if (diff == 1) {
                    dp[i][j] = (str.charAt(i) == str.charAt(j)) ? 2 : 0;
                } else {
                    //if outer matches & the inner is palindrome i.e >0
                    if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] > 0) {
                        dp[i][j] = 1 + dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] != 0) {
                    if (j - i + 1 > maxLen) {
                        //New substring
                        maxLen = j - i + 1;
                        ansStr = str.substring(i, j + 1);
                    }
                }

            }
        }

        return ansStr;
    }


    public static String lpsA2(String str) {

        String ansString = "";

        for (int i = 0; i < str.length(); i++) {
            String s1 = extendMatcher(str, i, i); //racecar
//            String s2 = extendMatcher(str, i, i + 1); //abba

            //Update ansString
            if (s1.length() > ansString.length()) {
                ansString = s1;
            }

//            if (s2.length() > ansString.length()) {
//                ansString = s2;
//            }
            System.out.println("Current AnsStr: "+ansString);
        }
        return ansString;
    }

    public static String extendMatcher(String s, int i, int j) {

        System.out.println("i :"+i+" j:"+j);
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }

            i--;
            j++;
        }
        System.out.println("Extend Matcher: i:"+i+" j:"+j+" "+s.substring(i + 1, j));
        return s.substring(i + 1, j);
    }


    public static void main(String[] args) {
        System.out.println(lpsubstringDP("aabaa"));
        System.out.println(lpsA2("aabaa"));
    }
}
