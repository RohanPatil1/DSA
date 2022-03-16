import java.util.*;

public class LongestCommonPrefix {
    


    //s1=geeks s2=dgeek output=[0,3]
    public int[] longestCommonPrefix(String s1, String s2){
        
        
        int n = s1.length();

        int commonPrefixLen=0;
        for(int i=0;i<n;i++){
            int s1Ptr =0;
            int s2Ptr = i;

            while((s1Ptr<n) && (s2Ptr<n) && (s1.charAt(s1Ptr) == s2.charAt(s2Ptr))){
                s1Ptr++;
                s2Ptr++;
            }
    
        commonPrefixLen = Math.max(commonPrefixLen,s1Ptr);
        }

        if(commonPrefixLen!=0){
            return new int[] {0,commonPrefixLen-1};       

        }
        
        return new int[] {-1,-1};     

    }

    public static String longestPrefix(String[] list){


        String prefix = list[0];


        for(int i=1;i<list.length;i++){
            String currStr = list[i];
            //if this becomes 0 it means prefix has become equal to currStr.
            while(currStr.indexOf(prefix)!=0){
                prefix = prefix.substring(0,prefix.length()-1);
            }
        
        
        }

        return prefix;
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"geeks","dgeek"};
        String s = longestPrefix(strs);
        System.out.println(s);
    }
}
