public class EditDistance {


    //------Recursion--------------
    public int minDistance(String word1, String word2) {
        return solve(word1, word2, word1.length() - 1, word2.length() - 1);
    }

    public int solve(String str1, String str2, int i, int j) {

        if (i < 0) {
            return j + 1;
        }

        //(2, -1)
        if (j < 0) {
            return i + 1;
        }


        if (str1.charAt(i) == str2.charAt(j)) {

            return solve(str1, str2, i - 1, j - 1);

        } else {

            int insert = solve(str1, str2, i, j - 1);
            int delete = solve(str1, str2, i - 1, j);
            int replace = solve(str1, str2, i - 1, j - 1);

            return 1 + Math.min(insert, Math.min(delete, replace));
        }

    }


//-------Tabulation-------------------

    public int minDistanceTab(String word1, String word2) {
        //Base Condition
        //Recurrance

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        //Init
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j; //Not +1 since we are doing 1-base indexing now
                }

                if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }

        //Fill the rest with ans
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }

            }
        }

        return dp[n][m];
    }

    //-------Tabulation---Space--Optimization---------------
    public int minDistanceTab2(String word1, String word2) {
        //Base Condition
        //Recurrance

        int n = word1.length();
        int m = word2.length();

//    int[][] dp = new int[n + 1][m + 1];
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];


        //Init
//        for (int i = 0; i < n + 1; i++) {
//            for (int j = 0; j < m + 1; j++) {
//                if (i == 0) {
//                    dp[i][j] = j; //Not +1 since we are doing 1-base indexing now
//                }
//
//                if (j == 0) {
//                    dp[i][j] = i;
//                }
//            }
//        }
        for (int j = 0; j < m; j++) prev[j] = j;

        //Fill the rest with ans
        for (int i = 1; i < n + 1; i++) {
            curr[0] = i;
            for (int j = 1; j < m + 1; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], prev[j - 1]));
                }

            }
            prev = curr;
        }

        return prev[m];
    }


}
