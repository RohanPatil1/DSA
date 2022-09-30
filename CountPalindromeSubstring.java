public class CountPalindromeSubstring {


    //Use approach of Longest Palindrome Substring, if the matrix has value >0 its palindrome so increase count
    public int countSubstrings(String s) {

        int palindromeCount = 0;

        int n = s.length();
        int[][] dp = new int[n][n];

        for(int diff =0; diff<n; diff++){
            for(int i=0,j= i + diff; j<n; j++,i++){

                if(i==j){
                    dp[i][j] = 1;
                    palindromeCount++;
                }else if(diff == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 2;
                        palindromeCount++;
                    }
                }else{

                    //if outer char matches & inner are palindrome
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]>0 ){
                        dp[i][j] = 2 + dp[i+1][j-1];
                        palindromeCount++;
                    }

                }

            }

        }


        return palindromeCount;
    }


    //For every char extend and see if palindrome
    public int countSubstrings2BEST(String s) {

        int palindromeCount = 0;

        int n = s.length();
        int left = 0, right =0;

        for(int i=0;i<n;i++){

            //For odd length
            left = right = i;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                palindromeCount++;

                left--;
                right++;
            }

            //For even length
            left = i;
            right = i+1;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                palindromeCount++;

                left--;
                right++;
            }

        }



        return palindromeCount;
    }



}
