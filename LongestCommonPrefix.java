import java.util.*;

public class LongestCommonPrefix {





    //-------M1

    String prefixFromTwoStr(String s1, String s2) {


        int i = 0;
        int j = 0;

        String prefixStr = "";

        while (i < s1.length() && j < s2.length()) {

            if (s1.charAt(i) != s2.charAt(j)) {
                break;
            }

            prefixStr += s1.charAt(i);

            i++;
            j++;
        }

        return prefixStr;
    }


    String longestCommonPrefix(String arr[], int n) {
        // code here

        String resultantPrefix = arr[0];


        for (int i = 1; i <= n - 1; i++) {
            resultantPrefix = prefixFromTwoStr(resultantPrefix, arr[i]);
        }
        if (resultantPrefix.length() == 0) {
            return "-1";
        }
        return resultantPrefix;
    }







    //---Better than M1 https://www.geeksforgeeks.org/longest-common-prefix-using-character-by-character-matching/
    // Since if first char is not matched then it will stop
    static int findMinLength(String arr[], int n)
    {
        int min = arr[0].length();

        for (int i = 1; i < n; i++)
        {
            if (arr[i].length() < min)
            {
                min = arr[i].length();
            }
        }

        return (min);
    }

    // A Function that returns the longest common prefix
    // from the array of strings
    static String commonPrefix(String arr[], int n)
    {
        int minlen = findMinLength(arr, n);

        String result = ""; // Our resultant string
        char current; // The current character

        for (int i = 0; i < minlen; i++)
        {
            // Current character (must be same
            // in all strings to be a part of
            // result)
            current = arr[0].charAt(i);

            for (int j = 1; j < n; j++)
            {
                if (arr[j].charAt(i) != current)
                {
                    return result;
                }
            }

            // Append to result
            result += (current);
        }

        return (result);
    }







    //-------M2

    //s1=geeks s2=dgeek output=[0,3]
    public int[] longestCommonPrefix(String s1, String s2) {


        int n = s1.length();

        int commonPrefixLen = 0;
        for (int i = 0; i < n; i++) {
            int s1Ptr = 0;
            int s2Ptr = i;

            while ((s1Ptr < n) && (s2Ptr < n) && (s1.charAt(s1Ptr) == s2.charAt(s2Ptr))) {
                s1Ptr++;
                s2Ptr++;
            }

            commonPrefixLen = Math.max(commonPrefixLen, s1Ptr);
        }

        if (commonPrefixLen != 0) {
            return new int[]{0, commonPrefixLen - 1};

        }

        return new int[]{-1, -1};

    }

    public static String longestPrefix(String[] list) {


        String prefix = list[0];


        for (int i = 1; i < list.length; i++) {
            String currStr = list[i];
            //if this becomes 0 it means prefix has become equal to currStr.
            while (currStr.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }


        }

        return prefix;
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"geeks", "dgeek"};
        String s = longestPrefix(strs);
        System.out.println(s);
    }
}
