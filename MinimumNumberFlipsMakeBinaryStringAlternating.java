public class MinimumNumberFlipsMakeBinaryStringAlternating {

    //------A1---Brute force
    public int minFlips(String s) {

        int n = s.length();
        int minDiff = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder(s);
        sb.append(s);
        String newString = sb.toString();

        int i = 0;
        int j = n - 1;
        while (j < 2 * n) {

            String currString = newString.substring(i, j + 1);
            int diff = getDiff(currString);

            minDiff = Math.min(minDiff, diff);
            i++;
            j++;
        }

        return minDiff;
    }

    public int getDiff(String s) {

        int n = s.length();

        //0 start
        int diff1 = 0;
        int diff2 = 0;
        for (int i = 0; i < s.length(); i++) {

            char curr = s.charAt(i);

            //0 start
            if (i % 2 == 0) {//even
                if (curr != '0') diff1++;
            } else {
                if (curr != '1') diff1++;
            }


            //1 start
            if (i % 2 != 0) {//odd
                if (curr != '0') diff2++;
            } else {
                if (curr != '1') diff2++;
            }

        }

        return Math.min(diff1, diff2);

    }

    /*
    Brute Force is O(N^2) since we are calculating for every N the diff.
    We can use Sliding window and remove ith calculation when i>=n i.e we reached rotated string 1st index so remove calculation for
    original's first calcuation
     */

    //Time O(2n) Space=O(2n)
    public int minFlipsA2(String s) {
        int n = s.length();
        int minDiff = Integer.MAX_VALUE;
        String newString = s + s;

        //Compose two possible alternate strings based on n value
        StringBuilder s1SB = new StringBuilder();
        StringBuilder s2SB = new StringBuilder();
        for (int i = 0; i < 2*n; i++) {
            s1SB.append((i % 2 == 0) ? '0' : '1');
            s2SB.append((i % 2 == 0) ? '1' : '0');
        }
        String s1 = s1SB.toString();
        String s2 = s2SB.toString();


        int diff1 = 0, diff2 = 0;
        for (int i = 0; i < 2 * n; i++) {
            char curr = newString.charAt(i);

            if (s1.charAt(i) != curr) diff1++;
            if (s2.charAt(i) != curr) diff2++;

            //Reached rotated string, remove ith calculation i.e (i-n)
            if (i >= n) {
                if (newString.charAt(i - n) != s1.charAt(i-n)) diff1--;
                if (newString.charAt(i - n) != s2.charAt(i-n)) diff2--;
            }

            //Calculate ans only when we have 'n' size string
            //since i started with 0 so n-1
            if (i >= n - 1) {
                minDiff = Math.min(minDiff, Math.min(diff1, diff2));
            }
        }

        return minDiff;

    }

    //Rather than making 2strings and calculating diffs, we can get the char based on i value saving n space
    //Time O(2n) Space=O(1)
    public int minFlipsA3(String s) {
        int n = s.length();
        int minDiff = Integer.MAX_VALUE;
//        String newString = s + s; //We will use i%n to get the same index

        int diff1 = 0, diff2 = 0;
        for (int i = 0; i < 2 * n; i++) {
            char curr = s.charAt(i%n);

            char s1Char = i % 2 == 0 ? '0' : '1';
            char s2Char = i % 2 == 0 ? '1' : '0';

            if (s1Char != curr) diff1++;
            if (s2Char != curr) diff2++;

            //Reached rotated string, remove ith calculation i.e (i-n)
            if (i >= n) {
                int windowStart = i - n;
                char newS1Char = windowStart%2 == 0? '0':'1';
                char newS2Char = windowStart%2 == 0? '1':'0';

                if (newS1Char != s.charAt(i-n)) diff1--;
                if (newS2Char != s.charAt(i-n)) diff2--;
            }

            //Calculate ans only when we have 'n' size string
            //since i started with 0 so n-1
            if (i >= n - 1) {
                minDiff = Math.min(minDiff, Math.min(diff1, diff2));
            }
        }

        return minDiff;

    }

}
